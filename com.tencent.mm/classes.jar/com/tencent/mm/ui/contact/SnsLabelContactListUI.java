package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.app.WorkerProfile;
import com.tencent.mm.contact.d;
import com.tencent.mm.f.a.ks;
import com.tencent.mm.f.a.ks.b;
import com.tencent.mm.f.a.tv;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.b.p;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class SnsLabelContactListUI
  extends MMActivity
{
  private ListView Een;
  private SnsObject Jwr;
  private String LRm;
  private a XwI;
  private ArrayList<String> XwJ;
  private int XwK;
  private b XwL;
  
  public SnsLabelContactListUI()
  {
    AppMethodBeat.i(38070);
    this.XwJ = new ArrayList();
    AppMethodBeat.o(38070);
  }
  
  private void dIy()
  {
    AppMethodBeat.i(38072);
    Iterator localIterator;
    if (this.Jwr.ExtFlag == 3)
    {
      this.LRm = getString(R.l.sns_label_can_not_see);
      localIterator = this.Jwr.BlackList.iterator();
      while (localIterator.hasNext()) {
        this.XwJ.add(((eaf)localIterator.next()).Ufy);
      }
      AppMethodBeat.o(38072);
      return;
    }
    if (this.Jwr.ExtFlag == 5)
    {
      this.LRm = getString(R.l.sns_label_can_see);
      localIterator = this.Jwr.GroupUser.iterator();
      while (localIterator.hasNext()) {
        this.XwJ.add(((eaf)localIterator.next()).Ufy);
      }
    }
    AppMethodBeat.o(38072);
  }
  
  public int getLayoutId()
  {
    return R.i.address;
  }
  
  public void initView()
  {
    AppMethodBeat.i(38073);
    setMMTitle(this.LRm);
    findViewById(R.h.loading_tips_area).setVisibility(8);
    this.Een = ((ListView)findViewById(R.h.address_contactlist));
    ((TextView)findViewById(R.h.dFv)).setVisibility(8);
    findViewById(R.h.dqz).setVisibility(8);
    this.Een.setBackgroundColor(getResources().getColor(R.e.white));
    ((View)this.Een.getParent()).setBackgroundColor(getResources().getColor(R.e.white));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(38062);
        SnsLabelContactListUI.this.finish();
        AppMethodBeat.o(38062);
        return true;
      }
    });
    showOptionMenu(false);
    if ((this.XwJ != null) && (this.XwJ.size() != 0))
    {
      this.XwI = new a(this, this.XwJ);
      this.Een.setAdapter(this.XwI);
      this.Een.setVisibility(0);
      this.Een.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(38063);
          Object localObject = new b();
          ((b)localObject).bn(paramAnonymousAdapterView);
          ((b)localObject).bn(paramAnonymousView);
          ((b)localObject).sg(paramAnonymousInt);
          ((b)localObject).Fs(paramAnonymousLong);
          a.c("com/tencent/mm/ui/contact/SnsLabelContactListUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((b)localObject).aFi());
          paramAnonymousView = new Intent();
          paramAnonymousAdapterView = (d)SnsLabelContactListUI.a(SnsLabelContactListUI.this).getItem(paramAnonymousInt);
          localObject = p.JPh;
          if (localObject == null)
          {
            SnsLabelContactListUI.this.finish();
            a.a(this, "com/tencent/mm/ui/contact/SnsLabelContactListUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(38063);
            return;
          }
          paramAnonymousView = ((j)localObject).f(paramAnonymousView, paramAnonymousAdapterView.field_username);
          if (paramAnonymousView == null)
          {
            SnsLabelContactListUI.this.finish();
            a.a(this, "com/tencent/mm/ui/contact/SnsLabelContactListUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(38063);
            return;
          }
          paramAnonymousView.putExtra("Contact_User", paramAnonymousAdapterView.field_username);
          WorkerProfile.abJ().ffK.c(paramAnonymousView, SnsLabelContactListUI.this);
          a.a(this, "com/tencent/mm/ui/contact/SnsLabelContactListUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(38063);
        }
      });
    }
    AppMethodBeat.o(38073);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(38071);
    super.onCreate(paramBundle);
    this.XwL = new b((byte)0);
    EventCenter.instance.addListener(this.XwL);
    this.XwK = getIntent().getIntExtra("sns_label_sns_info", -1);
    if (this.XwK == -1)
    {
      finish();
      AppMethodBeat.o(38071);
      return;
    }
    paramBundle = new ks();
    paramBundle.fIl.fBX = this.XwK;
    EventCenter.instance.publish(paramBundle);
    this.Jwr = paramBundle.fIm.fIn;
    if ((this.Jwr != null) && (((this.Jwr.ExtFlag == 3) && (this.Jwr.BlackList != null) && (this.Jwr.BlackList.size() > 0)) || ((this.Jwr.ExtFlag == 5) && (this.Jwr.GroupUser != null) && (this.Jwr.GroupUser.size() > 0))))
    {
      dIy();
      initView();
    }
    AppMethodBeat.o(38071);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(38075);
    EventCenter.instance.removeListener(this.XwL);
    super.onDestroy();
    AppMethodBeat.o(38075);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(38074);
    super.onResume();
    if (this.XwI != null) {
      this.XwI.notifyDataSetChanged();
    }
    AppMethodBeat.o(38074);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
    extends BaseAdapter
  {
    private bv KOY;
    private ColorStateList LRp;
    private ColorStateList LRq;
    private Map<Integer, d> XwN;
    private Context context;
    
    /* Error */
    public a(Context paramContext, java.util.List<String> paramList)
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 26	android/widget/BaseAdapter:<init>	()V
      //   4: ldc 27
      //   6: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   9: aload_0
      //   10: aconst_null
      //   11: putfield 35	com/tencent/mm/ui/contact/SnsLabelContactListUI$a:context	Landroid/content/Context;
      //   14: aload_0
      //   15: new 37	java/util/HashMap
      //   18: dup
      //   19: invokespecial 38	java/util/HashMap:<init>	()V
      //   22: putfield 40	com/tencent/mm/ui/contact/SnsLabelContactListUI$a:XwN	Ljava/util/Map;
      //   25: aload_0
      //   26: aconst_null
      //   27: putfield 42	com/tencent/mm/ui/contact/SnsLabelContactListUI$a:KOY	Lcom/tencent/mm/storage/bv;
      //   30: aload_0
      //   31: aload_1
      //   32: putfield 35	com/tencent/mm/ui/contact/SnsLabelContactListUI$a:context	Landroid/content/Context;
      //   35: aload_0
      //   36: getfield 40	com/tencent/mm/ui/contact/SnsLabelContactListUI$a:XwN	Ljava/util/Map;
      //   39: invokeinterface 47 1 0
      //   44: invokestatic 53	com/tencent/mm/model/bh:beI	()Lcom/tencent/mm/model/c;
      //   47: pop
      //   48: aload_0
      //   49: invokestatic 59	com/tencent/mm/model/c:bbL	()Lcom/tencent/mm/storage/bv;
      //   52: putfield 42	com/tencent/mm/ui/contact/SnsLabelContactListUI$a:KOY	Lcom/tencent/mm/storage/bv;
      //   55: aload_2
      //   56: invokeinterface 65 1 0
      //   61: astore_2
      //   62: iconst_0
      //   63: istore_3
      //   64: aload_2
      //   65: invokeinterface 71 1 0
      //   70: ifeq +82 -> 152
      //   73: aload_2
      //   74: invokeinterface 75 1 0
      //   79: checkcast 77	java/lang/String
      //   82: astore 6
      //   84: aload_0
      //   85: getfield 42	com/tencent/mm/ui/contact/SnsLabelContactListUI$a:KOY	Lcom/tencent/mm/storage/bv;
      //   88: aload 6
      //   90: invokeinterface 83 2 0
      //   95: astore 5
      //   97: aload 5
      //   99: ifnull +326 -> 425
      //   102: aload 5
      //   104: getfield 89	com/tencent/mm/f/c/ax:field_type	I
      //   107: invokestatic 95	com/tencent/mm/contact/d:rk	(I)Z
      //   110: ifeq +315 -> 425
      //   113: aload 6
      //   115: invokestatic 101	com/tencent/mm/model/z:PD	(Ljava/lang/String;)Z
      //   118: ifne +307 -> 425
      //   121: aload_0
      //   122: getfield 40	com/tencent/mm/ui/contact/SnsLabelContactListUI$a:XwN	Ljava/util/Map;
      //   125: astore 6
      //   127: iload_3
      //   128: iconst_1
      //   129: iadd
      //   130: istore 4
      //   132: aload 6
      //   134: iload_3
      //   135: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   138: aload 5
      //   140: invokeinterface 111 3 0
      //   145: pop
      //   146: iload 4
      //   148: istore_3
      //   149: goto -85 -> 64
      //   152: aload_1
      //   153: invokevirtual 117	android/content/Context:getResources	()Landroid/content/res/Resources;
      //   156: getstatic 122	com/tencent/mm/R$e:mm_list_textcolor_one	I
      //   159: invokevirtual 128	android/content/res/Resources:getXml	(I)Landroid/content/res/XmlResourceParser;
      //   162: astore_2
      //   163: aload_1
      //   164: invokevirtual 117	android/content/Context:getResources	()Landroid/content/res/Resources;
      //   167: getstatic 131	com/tencent/mm/R$e:mm_list_textcolor_spuser	I
      //   170: invokevirtual 128	android/content/res/Resources:getXml	(I)Landroid/content/res/XmlResourceParser;
      //   173: astore 7
      //   175: aload 7
      //   177: astore 6
      //   179: aload_2
      //   180: astore 5
      //   182: aload_0
      //   183: aload_1
      //   184: invokevirtual 117	android/content/Context:getResources	()Landroid/content/res/Resources;
      //   187: aload_2
      //   188: invokestatic 137	android/content/res/ColorStateList:createFromXml	(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;)Landroid/content/res/ColorStateList;
      //   191: putfield 139	com/tencent/mm/ui/contact/SnsLabelContactListUI$a:LRp	Landroid/content/res/ColorStateList;
      //   194: aload 7
      //   196: astore 6
      //   198: aload_2
      //   199: astore 5
      //   201: aload_0
      //   202: aload_1
      //   203: invokevirtual 117	android/content/Context:getResources	()Landroid/content/res/Resources;
      //   206: aload 7
      //   208: invokestatic 137	android/content/res/ColorStateList:createFromXml	(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;)Landroid/content/res/ColorStateList;
      //   211: putfield 141	com/tencent/mm/ui/contact/SnsLabelContactListUI$a:LRq	Landroid/content/res/ColorStateList;
      //   214: aload_2
      //   215: ifnull +9 -> 224
      //   218: aload_2
      //   219: invokeinterface 146 1 0
      //   224: aload 7
      //   226: ifnull +157 -> 383
      //   229: aload 7
      //   231: invokeinterface 146 1 0
      //   236: ldc 27
      //   238: invokestatic 149	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   241: return
      //   242: astore_1
      //   243: aconst_null
      //   244: astore 7
      //   246: aconst_null
      //   247: astore_2
      //   248: aload 7
      //   250: astore 6
      //   252: aload_2
      //   253: astore 5
      //   255: ldc 151
      //   257: aload_1
      //   258: ldc 153
      //   260: iconst_0
      //   261: anewarray 155	java/lang/Object
      //   264: invokestatic 161	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   267: aload_2
      //   268: ifnull +9 -> 277
      //   271: aload_2
      //   272: invokeinterface 146 1 0
      //   277: aload 7
      //   279: ifnull +104 -> 383
      //   282: aload 7
      //   284: invokeinterface 146 1 0
      //   289: ldc 27
      //   291: invokestatic 149	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   294: return
      //   295: astore_1
      //   296: aconst_null
      //   297: astore 7
      //   299: aconst_null
      //   300: astore_2
      //   301: aload 7
      //   303: astore 6
      //   305: aload_2
      //   306: astore 5
      //   308: ldc 151
      //   310: aload_1
      //   311: ldc 153
      //   313: iconst_0
      //   314: anewarray 155	java/lang/Object
      //   317: invokestatic 161	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   320: aload_2
      //   321: ifnull +9 -> 330
      //   324: aload_2
      //   325: invokeinterface 146 1 0
      //   330: aload 7
      //   332: ifnull +51 -> 383
      //   335: aload 7
      //   337: invokeinterface 146 1 0
      //   342: ldc 27
      //   344: invokestatic 149	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   347: return
      //   348: astore_1
      //   349: aconst_null
      //   350: astore 6
      //   352: aconst_null
      //   353: astore_2
      //   354: aload_2
      //   355: ifnull +9 -> 364
      //   358: aload_2
      //   359: invokeinterface 146 1 0
      //   364: aload 6
      //   366: ifnull +10 -> 376
      //   369: aload 6
      //   371: invokeinterface 146 1 0
      //   376: ldc 27
      //   378: invokestatic 149	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   381: aload_1
      //   382: athrow
      //   383: ldc 27
      //   385: invokestatic 149	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   388: return
      //   389: astore_1
      //   390: aconst_null
      //   391: astore 6
      //   393: goto -39 -> 354
      //   396: astore_1
      //   397: aload 5
      //   399: astore_2
      //   400: goto -46 -> 354
      //   403: astore_1
      //   404: aconst_null
      //   405: astore 7
      //   407: goto -106 -> 301
      //   410: astore_1
      //   411: goto -110 -> 301
      //   414: astore_1
      //   415: aconst_null
      //   416: astore 7
      //   418: goto -170 -> 248
      //   421: astore_1
      //   422: goto -174 -> 248
      //   425: goto -276 -> 149
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	428	0	this	a
      //   0	428	1	paramContext	Context
      //   0	428	2	paramList	java.util.List<String>
      //   63	86	3	i	int
      //   130	17	4	j	int
      //   95	303	5	localObject1	Object
      //   82	310	6	localObject2	Object
      //   173	244	7	localXmlResourceParser	android.content.res.XmlResourceParser
      // Exception table:
      //   from	to	target	type
      //   152	163	242	org/xmlpull/v1/XmlPullParserException
      //   152	163	295	java/io/IOException
      //   152	163	348	finally
      //   163	175	389	finally
      //   182	194	396	finally
      //   201	214	396	finally
      //   255	267	396	finally
      //   308	320	396	finally
      //   163	175	403	java/io/IOException
      //   182	194	410	java/io/IOException
      //   201	214	410	java/io/IOException
      //   163	175	414	org/xmlpull/v1/XmlPullParserException
      //   182	194	421	org/xmlpull/v1/XmlPullParserException
      //   201	214	421	org/xmlpull/v1/XmlPullParserException
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(38065);
      int i = this.XwN.size();
      AppMethodBeat.o(38065);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(38066);
      if (paramInt < 0)
      {
        AppMethodBeat.o(38066);
        return null;
      }
      d locald = (d)this.XwN.get(Integer.valueOf(paramInt));
      AppMethodBeat.o(38066);
      return locald;
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(38067);
      d locald;
      TextView localTextView;
      if (paramView == null)
      {
        paramView = View.inflate(this.context, R.i.efr, null);
        paramViewGroup = new SnsLabelContactListUI.c((byte)0);
        paramViewGroup.DUW = ((TextView)paramView.findViewById(R.h.dCx));
        paramViewGroup.jkT = ((MaskLayout)paramView.findViewById(R.h.dCv));
        paramViewGroup.jbe = ((TextView)paramView.findViewById(R.h.dCB));
        paramViewGroup.LRr = ((TextView)paramView.findViewById(R.h.dCt));
        paramView.setTag(paramViewGroup);
        getItem(paramInt);
        locald = (d)getItem(paramInt);
        paramViewGroup.DUW.setVisibility(8);
        localTextView = paramViewGroup.jbe;
        if (ab.QX(locald.field_username)) {
          break label233;
        }
      }
      label233:
      for (ColorStateList localColorStateList = this.LRp;; localColorStateList = this.LRq)
      {
        localTextView.setTextColor(localColorStateList);
        a.b.C((ImageView)paramViewGroup.jkT.getContentView(), locald.field_username);
        paramViewGroup.LRr.setVisibility(8);
        paramViewGroup.jkT.setVisibility(0);
        paramViewGroup.jbe.setText(l.b(this.context, locald.ays(), paramViewGroup.jbe.getTextSize()));
        paramViewGroup.jbe.setVisibility(0);
        AppMethodBeat.o(38067);
        return paramView;
        paramViewGroup = (SnsLabelContactListUI.c)paramView.getTag();
        break;
      }
    }
  }
  
  final class b
    extends IListener<tv>
  {
    private b()
    {
      AppMethodBeat.i(161549);
      this.__eventId = tv.class.getName().hashCode();
      AppMethodBeat.o(161549);
    }
  }
  
  static final class c
  {
    TextView DUW;
    TextView LRr;
    TextView jbe;
    MaskLayout jkT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SnsLabelContactListUI
 * JD-Core Version:    0.7.0.1
 */