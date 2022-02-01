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
import com.tencent.mm.app.WorkerProfile;
import com.tencent.mm.g.a.jm;
import com.tencent.mm.g.a.jm.b;
import com.tencent.mm.g.a.rx;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class SnsLabelContactListUI
  extends MMActivity
{
  private String AUW;
  private a Kqr;
  private ArrayList<String> Kqs;
  private int Kqt;
  private b Kqu;
  private ListView uXc;
  private SnsObject yVL;
  
  public SnsLabelContactListUI()
  {
    AppMethodBeat.i(38070);
    this.Kqs = new ArrayList();
    AppMethodBeat.o(38070);
  }
  
  private void fIz()
  {
    AppMethodBeat.i(38072);
    Iterator localIterator;
    if (this.yVL.ExtFlag == 3)
    {
      this.AUW = getString(2131763851);
      localIterator = this.yVL.BlackList.iterator();
      while (localIterator.hasNext()) {
        this.Kqs.add(((cwt)localIterator.next()).HoB);
      }
      AppMethodBeat.o(38072);
      return;
    }
    if (this.yVL.ExtFlag == 5)
    {
      this.AUW = getString(2131763852);
      localIterator = this.yVL.GroupUser.iterator();
      while (localIterator.hasNext()) {
        this.Kqs.add(((cwt)localIterator.next()).HoB);
      }
    }
    AppMethodBeat.o(38072);
  }
  
  public int getLayoutId()
  {
    return 2131492947;
  }
  
  public void initView()
  {
    AppMethodBeat.i(38073);
    setMMTitle(this.AUW);
    findViewById(2131301512).setVisibility(8);
    this.uXc = ((ListView)findViewById(2131296471));
    ((TextView)findViewById(2131299460)).setVisibility(8);
    findViewById(2131296489).setVisibility(8);
    this.uXc.setBackgroundColor(getResources().getColor(2131101179));
    ((View)this.uXc.getParent()).setBackgroundColor(getResources().getColor(2131101179));
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
    if ((this.Kqs != null) && (this.Kqs.size() != 0))
    {
      this.Kqr = new a(this, this.Kqs);
      this.uXc.setAdapter(this.Kqr);
      this.uXc.setVisibility(0);
      this.uXc.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(38063);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousAdapterView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).mr(paramAnonymousInt);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).qY(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/SnsLabelContactListUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          paramAnonymousView = new Intent();
          paramAnonymousAdapterView = (com.tencent.mm.o.b)SnsLabelContactListUI.a(SnsLabelContactListUI.this).getItem(paramAnonymousInt);
          localObject = o.zbX;
          if (localObject == null)
          {
            SnsLabelContactListUI.this.finish();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SnsLabelContactListUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(38063);
            return;
          }
          paramAnonymousView = ((i)localObject).f(paramAnonymousView, paramAnonymousAdapterView.field_username);
          if (paramAnonymousView == null)
          {
            SnsLabelContactListUI.this.finish();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SnsLabelContactListUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(38063);
            return;
          }
          paramAnonymousView.putExtra("Contact_User", paramAnonymousAdapterView.field_username);
          WorkerProfile.MZ().cVY.c(paramAnonymousView, SnsLabelContactListUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SnsLabelContactListUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
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
    this.Kqu = new b((byte)0);
    com.tencent.mm.sdk.b.a.IbL.c(this.Kqu);
    this.Kqt = getIntent().getIntExtra("sns_label_sns_info", -1);
    if (this.Kqt == -1)
    {
      finish();
      AppMethodBeat.o(38071);
      return;
    }
    paramBundle = new jm();
    paramBundle.dwo.dqR = this.Kqt;
    com.tencent.mm.sdk.b.a.IbL.l(paramBundle);
    this.yVL = paramBundle.dwp.dwq;
    if ((this.yVL != null) && (((this.yVL.ExtFlag == 3) && (this.yVL.BlackList != null) && (this.yVL.BlackList.size() > 0)) || ((this.yVL.ExtFlag == 5) && (this.yVL.GroupUser != null) && (this.yVL.GroupUser.size() > 0))))
    {
      fIz();
      initView();
    }
    AppMethodBeat.o(38071);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(38075);
    com.tencent.mm.sdk.b.a.IbL.d(this.Kqu);
    super.onDestroy();
    AppMethodBeat.o(38075);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(38074);
    super.onResume();
    if (this.Kqr != null) {
      this.Kqr.notifyDataSetChanged();
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
    private ColorStateList AUZ;
    private ColorStateList AVa;
    private bp AaP;
    private Map<Integer, com.tencent.mm.o.b> Kqw;
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
      //   22: putfield 40	com/tencent/mm/ui/contact/SnsLabelContactListUI$a:Kqw	Ljava/util/Map;
      //   25: aload_0
      //   26: aconst_null
      //   27: putfield 42	com/tencent/mm/ui/contact/SnsLabelContactListUI$a:AaP	Lcom/tencent/mm/storage/bp;
      //   30: aload_0
      //   31: aload_1
      //   32: putfield 35	com/tencent/mm/ui/contact/SnsLabelContactListUI$a:context	Landroid/content/Context;
      //   35: aload_0
      //   36: getfield 40	com/tencent/mm/ui/contact/SnsLabelContactListUI$a:Kqw	Ljava/util/Map;
      //   39: invokeinterface 47 1 0
      //   44: invokestatic 53	com/tencent/mm/model/ba:aBQ	()Lcom/tencent/mm/model/c;
      //   47: pop
      //   48: aload_0
      //   49: invokestatic 59	com/tencent/mm/model/c:azp	()Lcom/tencent/mm/storage/bp;
      //   52: putfield 42	com/tencent/mm/ui/contact/SnsLabelContactListUI$a:AaP	Lcom/tencent/mm/storage/bp;
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
      //   85: getfield 42	com/tencent/mm/ui/contact/SnsLabelContactListUI$a:AaP	Lcom/tencent/mm/storage/bp;
      //   88: aload 6
      //   90: invokeinterface 83 2 0
      //   95: astore 5
      //   97: aload 5
      //   99: ifnull +324 -> 423
      //   102: aload 5
      //   104: getfield 89	com/tencent/mm/g/c/aw:field_type	I
      //   107: invokestatic 95	com/tencent/mm/o/b:lM	(I)Z
      //   110: ifeq +313 -> 423
      //   113: aload 6
      //   115: invokestatic 101	com/tencent/mm/model/u:za	(Ljava/lang/String;)Z
      //   118: ifne +305 -> 423
      //   121: aload_0
      //   122: getfield 40	com/tencent/mm/ui/contact/SnsLabelContactListUI$a:Kqw	Ljava/util/Map;
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
      //   156: ldc 118
      //   158: invokevirtual 124	android/content/res/Resources:getXml	(I)Landroid/content/res/XmlResourceParser;
      //   161: astore_2
      //   162: aload_1
      //   163: invokevirtual 117	android/content/Context:getResources	()Landroid/content/res/Resources;
      //   166: ldc 125
      //   168: invokevirtual 124	android/content/res/Resources:getXml	(I)Landroid/content/res/XmlResourceParser;
      //   171: astore 7
      //   173: aload 7
      //   175: astore 6
      //   177: aload_2
      //   178: astore 5
      //   180: aload_0
      //   181: aload_1
      //   182: invokevirtual 117	android/content/Context:getResources	()Landroid/content/res/Resources;
      //   185: aload_2
      //   186: invokestatic 131	android/content/res/ColorStateList:createFromXml	(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;)Landroid/content/res/ColorStateList;
      //   189: putfield 133	com/tencent/mm/ui/contact/SnsLabelContactListUI$a:AUZ	Landroid/content/res/ColorStateList;
      //   192: aload 7
      //   194: astore 6
      //   196: aload_2
      //   197: astore 5
      //   199: aload_0
      //   200: aload_1
      //   201: invokevirtual 117	android/content/Context:getResources	()Landroid/content/res/Resources;
      //   204: aload 7
      //   206: invokestatic 131	android/content/res/ColorStateList:createFromXml	(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;)Landroid/content/res/ColorStateList;
      //   209: putfield 135	com/tencent/mm/ui/contact/SnsLabelContactListUI$a:AVa	Landroid/content/res/ColorStateList;
      //   212: aload_2
      //   213: ifnull +9 -> 222
      //   216: aload_2
      //   217: invokeinterface 140 1 0
      //   222: aload 7
      //   224: ifnull +157 -> 381
      //   227: aload 7
      //   229: invokeinterface 140 1 0
      //   234: ldc 27
      //   236: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   239: return
      //   240: astore_1
      //   241: aconst_null
      //   242: astore 7
      //   244: aconst_null
      //   245: astore_2
      //   246: aload 7
      //   248: astore 6
      //   250: aload_2
      //   251: astore 5
      //   253: ldc 145
      //   255: aload_1
      //   256: ldc 147
      //   258: iconst_0
      //   259: anewarray 149	java/lang/Object
      //   262: invokestatic 155	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   265: aload_2
      //   266: ifnull +9 -> 275
      //   269: aload_2
      //   270: invokeinterface 140 1 0
      //   275: aload 7
      //   277: ifnull +104 -> 381
      //   280: aload 7
      //   282: invokeinterface 140 1 0
      //   287: ldc 27
      //   289: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   292: return
      //   293: astore_1
      //   294: aconst_null
      //   295: astore 7
      //   297: aconst_null
      //   298: astore_2
      //   299: aload 7
      //   301: astore 6
      //   303: aload_2
      //   304: astore 5
      //   306: ldc 145
      //   308: aload_1
      //   309: ldc 147
      //   311: iconst_0
      //   312: anewarray 149	java/lang/Object
      //   315: invokestatic 155	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   318: aload_2
      //   319: ifnull +9 -> 328
      //   322: aload_2
      //   323: invokeinterface 140 1 0
      //   328: aload 7
      //   330: ifnull +51 -> 381
      //   333: aload 7
      //   335: invokeinterface 140 1 0
      //   340: ldc 27
      //   342: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   345: return
      //   346: astore_1
      //   347: aconst_null
      //   348: astore 6
      //   350: aconst_null
      //   351: astore_2
      //   352: aload_2
      //   353: ifnull +9 -> 362
      //   356: aload_2
      //   357: invokeinterface 140 1 0
      //   362: aload 6
      //   364: ifnull +10 -> 374
      //   367: aload 6
      //   369: invokeinterface 140 1 0
      //   374: ldc 27
      //   376: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   379: aload_1
      //   380: athrow
      //   381: ldc 27
      //   383: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   386: return
      //   387: astore_1
      //   388: aconst_null
      //   389: astore 6
      //   391: goto -39 -> 352
      //   394: astore_1
      //   395: aload 5
      //   397: astore_2
      //   398: goto -46 -> 352
      //   401: astore_1
      //   402: aconst_null
      //   403: astore 7
      //   405: goto -106 -> 299
      //   408: astore_1
      //   409: goto -110 -> 299
      //   412: astore_1
      //   413: aconst_null
      //   414: astore 7
      //   416: goto -170 -> 246
      //   419: astore_1
      //   420: goto -174 -> 246
      //   423: goto -274 -> 149
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	426	0	this	a
      //   0	426	1	paramContext	Context
      //   0	426	2	paramList	java.util.List<String>
      //   63	86	3	i	int
      //   130	17	4	j	int
      //   95	301	5	localObject1	Object
      //   82	308	6	localObject2	Object
      //   171	244	7	localXmlResourceParser	android.content.res.XmlResourceParser
      // Exception table:
      //   from	to	target	type
      //   152	162	240	org/xmlpull/v1/XmlPullParserException
      //   152	162	293	java/io/IOException
      //   152	162	346	finally
      //   162	173	387	finally
      //   180	192	394	finally
      //   199	212	394	finally
      //   253	265	394	finally
      //   306	318	394	finally
      //   162	173	401	java/io/IOException
      //   180	192	408	java/io/IOException
      //   199	212	408	java/io/IOException
      //   162	173	412	org/xmlpull/v1/XmlPullParserException
      //   180	192	419	org/xmlpull/v1/XmlPullParserException
      //   199	212	419	org/xmlpull/v1/XmlPullParserException
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(38065);
      int i = this.Kqw.size();
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
      com.tencent.mm.o.b localb = (com.tencent.mm.o.b)this.Kqw.get(Integer.valueOf(paramInt));
      AppMethodBeat.o(38066);
      return localb;
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(38067);
      com.tencent.mm.o.b localb;
      TextView localTextView;
      if (paramView == null)
      {
        paramView = View.inflate(this.context, 2131493644, null);
        paramViewGroup = new SnsLabelContactListUI.c((byte)0);
        paramViewGroup.uQG = ((TextView)paramView.findViewById(2131298724));
        paramViewGroup.fTA = ((MaskLayout)paramView.findViewById(2131298721));
        paramViewGroup.fPC = ((TextView)paramView.findViewById(2131298729));
        paramViewGroup.AVb = ((TextView)paramView.findViewById(2131298719));
        paramView.setTag(paramViewGroup);
        getItem(paramInt);
        localb = (com.tencent.mm.o.b)getItem(paramInt);
        paramViewGroup.uQG.setVisibility(8);
        localTextView = paramViewGroup.fPC;
        if (w.Ap(localb.field_username)) {
          break label228;
        }
      }
      label228:
      for (ColorStateList localColorStateList = this.AUZ;; localColorStateList = this.AVa)
      {
        localTextView.setTextColor(localColorStateList);
        a.b.w((ImageView)paramViewGroup.fTA.getContentView(), localb.field_username);
        paramViewGroup.AVb.setVisibility(8);
        paramViewGroup.fTA.setVisibility(0);
        paramViewGroup.fPC.setText(k.b(this.context, localb.adv(), paramViewGroup.fPC.getTextSize()));
        paramViewGroup.fPC.setVisibility(0);
        AppMethodBeat.o(38067);
        return paramView;
        paramViewGroup = (SnsLabelContactListUI.c)paramView.getTag();
        break;
      }
    }
  }
  
  final class b
    extends c<rx>
  {
    private b()
    {
      AppMethodBeat.i(161549);
      this.__eventId = rx.class.getName().hashCode();
      AppMethodBeat.o(161549);
    }
  }
  
  static final class c
  {
    TextView AVb;
    TextView fPC;
    MaskLayout fTA;
    TextView uQG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SnsLabelContactListUI
 * JD-Core Version:    0.7.0.1
 */