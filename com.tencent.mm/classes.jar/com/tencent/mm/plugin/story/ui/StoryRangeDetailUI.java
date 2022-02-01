package com.tencent.mm.plugin.story.ui;

import android.app.Activity;
import android.content.Context;
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
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.model.w;
import com.tencent.mm.n.b;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.i.a.f;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/StoryRangeDetailUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "adapter", "Lcom/tencent/mm/plugin/story/ui/StoryRangeDetailUI$ContactsAdapter;", "blackList", "Ljava/util/ArrayList;", "", "contactLV", "Landroid/widget/ListView;", "groupList", "localId", "", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "titile", "userNames", "getLayoutId", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "prepareData", "Companion", "ContactsAdapter", "ViewHolder", "plugin-story_release"})
public final class StoryRangeDetailUI
  extends MMActivity
{
  private static final String TAG = "MicroMsg.StoryRangeDetailUI";
  public static final a yqa;
  private int dzf;
  private final ArrayList<String> fPT;
  private final ArrayList<String> fyj;
  private final ArrayList<String> jcS;
  private ListView sMV;
  private com.tencent.mm.plugin.story.i.j yje;
  private b ypY;
  private String ypZ;
  
  static
  {
    AppMethodBeat.i(119657);
    yqa = new a((byte)0);
    TAG = "MicroMsg.StoryRangeDetailUI";
    AppMethodBeat.o(119657);
  }
  
  public StoryRangeDetailUI()
  {
    AppMethodBeat.i(119656);
    this.fyj = new ArrayList();
    this.fPT = new ArrayList();
    this.jcS = new ArrayList();
    AppMethodBeat.o(119656);
  }
  
  public final int getLayoutId()
  {
    return 2131495717;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(119654);
    setMMTitle(this.ypZ);
    Object localObject = findViewById(2131296471);
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.widget.ListView");
      AppMethodBeat.o(119654);
      throw ((Throwable)localObject);
    }
    this.sMV = ((ListView)localObject);
    localObject = this.sMV;
    if (localObject != null) {
      ((ListView)localObject).setBackgroundColor(getResources().getColor(2131101179));
    }
    localObject = this.sMV;
    if (localObject != null) {}
    for (localObject = ((ListView)localObject).getParent(); localObject == null; localObject = null)
    {
      localObject = new v("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(119654);
      throw ((Throwable)localObject);
    }
    ((View)localObject).setBackgroundColor(getResources().getColor(2131101179));
    setBackBtn((MenuItem.OnMenuItemClickListener)new d(this));
    showOptionMenu(false);
    if ((this.fyj != null) && (this.fyj.size() != 0))
    {
      this.ypY = new b((Context)this, (List)this.fyj);
      localObject = this.sMV;
      if (localObject != null) {
        ((ListView)localObject).setAdapter((ListAdapter)this.ypY);
      }
      localObject = this.sMV;
      if (localObject != null) {
        ((ListView)localObject).setVisibility(0);
      }
      localObject = this.sMV;
      if (localObject != null)
      {
        ((ListView)localObject).setOnItemClickListener((AdapterView.OnItemClickListener)new e(this));
        AppMethodBeat.o(119654);
        return;
      }
    }
    AppMethodBeat.o(119654);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(119653);
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    Object localObject = a.f.yoE;
    this.dzf = paramBundle.getIntExtra(a.f.dKs(), -1);
    paramBundle = com.tencent.mm.plugin.story.f.j.yfh;
    this.yje = j.b.dHd().OI(this.dzf);
    localObject = this.fPT;
    paramBundle = this.yje;
    if (paramBundle != null)
    {
      paramBundle = (Collection)paramBundle.abP();
      ((ArrayList)localObject).addAll(paramBundle);
      localObject = this.jcS;
      paramBundle = this.yje;
      if (paramBundle == null) {
        break label191;
      }
      paramBundle = (Collection)paramBundle.dKF();
      label99:
      ((ArrayList)localObject).addAll(paramBundle);
      if (this.dzf != -1)
      {
        paramBundle = (Collection)this.fPT;
        if ((paramBundle != null) && (!paramBundle.isEmpty())) {
          break label205;
        }
        i = 1;
        label136:
        if (i == 0) {
          break label215;
        }
        paramBundle = (Collection)this.jcS;
        if ((paramBundle != null) && (!paramBundle.isEmpty())) {
          break label210;
        }
      }
    }
    label191:
    label205:
    label210:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label215;
      }
      finish();
      AppMethodBeat.o(119653);
      return;
      paramBundle = (Collection)new ArrayList();
      break;
      paramBundle = (Collection)new ArrayList();
      break label99;
      i = 0;
      break label136;
    }
    label215:
    paramBundle = (Collection)this.jcS;
    if ((paramBundle == null) || (paramBundle.isEmpty()))
    {
      i = 1;
      if (i != 0) {
        break label283;
      }
      this.ypZ = getString(2131764283);
      this.fyj.addAll((Collection)this.jcS);
    }
    label283:
    label342:
    for (;;)
    {
      initView();
      AppMethodBeat.o(119653);
      return;
      i = 0;
      break;
      paramBundle = (Collection)this.fPT;
      if ((paramBundle == null) || (paramBundle.isEmpty())) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label342;
        }
        this.ypZ = getString(2131764284);
        this.fyj.addAll((Collection)this.fPT);
        break;
      }
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(119655);
    super.onResume();
    if (this.ypY != null)
    {
      b localb = this.ypY;
      if (localb != null)
      {
        localb.notifyDataSetChanged();
        AppMethodBeat.o(119655);
        return;
      }
    }
    AppMethodBeat.o(119655);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/StoryRangeDetailUI$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/StoryRangeDetailUI$ContactsAdapter;", "Landroid/widget/BaseAdapter;", "context", "Landroid/content/Context;", "userNames", "", "", "(Landroid/content/Context;Ljava/util/List;)V", "cstg", "Lcom/tencent/mm/storage/IContactStorage;", "list", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/contact/RContact;", "normal", "Landroid/content/res/ColorStateList;", "spuser", "getCount", "getItem", "", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "plugin-story_release"})
  static final class b
    extends BaseAdapter
  {
    private Context context;
    private bg xwF;
    private final HashMap<Integer, b> yqb;
    private ColorStateList yqc;
    private ColorStateList yqd;
    
    /* Error */
    public b(Context paramContext, List<String> paramList)
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_3
      //   2: aload_1
      //   3: ldc 51
      //   5: invokestatic 57	d/g/b/k:h	(Ljava/lang/Object;Ljava/lang/String;)V
      //   8: aload_2
      //   9: ldc 58
      //   11: invokestatic 57	d/g/b/k:h	(Ljava/lang/Object;Ljava/lang/String;)V
      //   14: aload_0
      //   15: invokespecial 61	android/widget/BaseAdapter:<init>	()V
      //   18: ldc 62
      //   20: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   23: aload_0
      //   24: aload_1
      //   25: putfield 70	com/tencent/mm/plugin/story/ui/StoryRangeDetailUI$b:context	Landroid/content/Context;
      //   28: aload_0
      //   29: new 72	java/util/HashMap
      //   32: dup
      //   33: invokespecial 73	java/util/HashMap:<init>	()V
      //   36: putfield 75	com/tencent/mm/plugin/story/ui/StoryRangeDetailUI$b:yqb	Ljava/util/HashMap;
      //   39: aload_0
      //   40: getfield 75	com/tencent/mm/plugin/story/ui/StoryRangeDetailUI$b:yqb	Ljava/util/HashMap;
      //   43: invokevirtual 78	java/util/HashMap:clear	()V
      //   46: ldc 80
      //   48: invokestatic 86	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
      //   51: astore 5
      //   53: aload 5
      //   55: ldc 88
      //   57: invokestatic 91	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
      //   60: aload_0
      //   61: aload 5
      //   63: checkcast 80	com/tencent/mm/plugin/messenger/foundation/a/k
      //   66: invokeinterface 95 1 0
      //   71: putfield 97	com/tencent/mm/plugin/story/ui/StoryRangeDetailUI$b:xwF	Lcom/tencent/mm/storage/bg;
      //   74: aload_2
      //   75: invokeinterface 103 1 0
      //   80: astore_2
      //   81: aload_2
      //   82: invokeinterface 109 1 0
      //   87: ifeq +103 -> 190
      //   90: aload_2
      //   91: invokeinterface 113 1 0
      //   96: checkcast 115	java/lang/String
      //   99: astore 5
      //   101: aload_0
      //   102: getfield 97	com/tencent/mm/plugin/story/ui/StoryRangeDetailUI$b:xwF	Lcom/tencent/mm/storage/bg;
      //   105: astore 6
      //   107: aload 6
      //   109: ifnonnull +6 -> 115
      //   112: invokestatic 118	d/g/b/k:fvU	()V
      //   115: aload 6
      //   117: aload 5
      //   119: invokeinterface 124 2 0
      //   124: astore 6
      //   126: iload_3
      //   127: istore 4
      //   129: aload 6
      //   131: ifnull +53 -> 184
      //   134: iload_3
      //   135: istore 4
      //   137: aload 6
      //   139: invokevirtual 129	com/tencent/mm/storage/af:ZJ	()Z
      //   142: ifeq +42 -> 184
      //   145: iload_3
      //   146: istore 4
      //   148: aload 5
      //   150: invokestatic 135	com/tencent/mm/model/u:se	(Ljava/lang/String;)Z
      //   153: ifne +31 -> 184
      //   156: aload_0
      //   157: getfield 75	com/tencent/mm/plugin/story/ui/StoryRangeDetailUI$b:yqb	Ljava/util/HashMap;
      //   160: checkcast 137	java/util/Map
      //   163: astore 5
      //   165: iload_3
      //   166: iconst_1
      //   167: iadd
      //   168: istore 4
      //   170: aload 5
      //   172: iload_3
      //   173: invokestatic 143	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   176: aload 6
      //   178: invokeinterface 147 3 0
      //   183: pop
      //   184: iload 4
      //   186: istore_3
      //   187: goto -106 -> 81
      //   190: aload_1
      //   191: invokevirtual 153	android/content/Context:getResources	()Landroid/content/res/Resources;
      //   194: ldc 154
      //   196: invokevirtual 160	android/content/res/Resources:getXml	(I)Landroid/content/res/XmlResourceParser;
      //   199: astore_2
      //   200: aload_1
      //   201: invokevirtual 153	android/content/Context:getResources	()Landroid/content/res/Resources;
      //   204: ldc 161
      //   206: invokevirtual 160	android/content/res/Resources:getXml	(I)Landroid/content/res/XmlResourceParser;
      //   209: astore 7
      //   211: aload_2
      //   212: astore 6
      //   214: aload 7
      //   216: astore 5
      //   218: aload_0
      //   219: aload_1
      //   220: invokevirtual 153	android/content/Context:getResources	()Landroid/content/res/Resources;
      //   223: aload_2
      //   224: checkcast 163	org/xmlpull/v1/XmlPullParser
      //   227: invokestatic 169	android/content/res/ColorStateList:createFromXml	(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;)Landroid/content/res/ColorStateList;
      //   230: putfield 171	com/tencent/mm/plugin/story/ui/StoryRangeDetailUI$b:yqc	Landroid/content/res/ColorStateList;
      //   233: aload_2
      //   234: astore 6
      //   236: aload 7
      //   238: astore 5
      //   240: aload_0
      //   241: aload_1
      //   242: invokevirtual 153	android/content/Context:getResources	()Landroid/content/res/Resources;
      //   245: aload 7
      //   247: checkcast 163	org/xmlpull/v1/XmlPullParser
      //   250: invokestatic 169	android/content/res/ColorStateList:createFromXml	(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;)Landroid/content/res/ColorStateList;
      //   253: putfield 173	com/tencent/mm/plugin/story/ui/StoryRangeDetailUI$b:yqd	Landroid/content/res/ColorStateList;
      //   256: aload_2
      //   257: ifnull +9 -> 266
      //   260: aload_2
      //   261: invokeinterface 178 1 0
      //   266: aload 7
      //   268: ifnull +16 -> 284
      //   271: aload 7
      //   273: invokeinterface 178 1 0
      //   278: ldc 62
      //   280: invokestatic 181	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   283: return
      //   284: ldc 62
      //   286: invokestatic 181	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   289: return
      //   290: astore_1
      //   291: aconst_null
      //   292: astore 7
      //   294: aconst_null
      //   295: astore_2
      //   296: aload_2
      //   297: astore 6
      //   299: aload 7
      //   301: astore 5
      //   303: invokestatic 185	com/tencent/mm/plugin/story/ui/StoryRangeDetailUI:access$getTAG$cp	()Ljava/lang/String;
      //   306: aload_1
      //   307: checkcast 187	java/lang/Throwable
      //   310: ldc 188
      //   312: iconst_0
      //   313: anewarray 190	java/lang/Object
      //   316: invokestatic 196	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   319: aload_2
      //   320: ifnull +9 -> 329
      //   323: aload_2
      //   324: invokeinterface 178 1 0
      //   329: aload 7
      //   331: ifnull +16 -> 347
      //   334: aload 7
      //   336: invokeinterface 178 1 0
      //   341: ldc 62
      //   343: invokestatic 181	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   346: return
      //   347: ldc 62
      //   349: invokestatic 181	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   352: return
      //   353: astore_1
      //   354: aconst_null
      //   355: astore 7
      //   357: aconst_null
      //   358: astore_2
      //   359: aload_2
      //   360: astore 6
      //   362: aload 7
      //   364: astore 5
      //   366: invokestatic 185	com/tencent/mm/plugin/story/ui/StoryRangeDetailUI:access$getTAG$cp	()Ljava/lang/String;
      //   369: aload_1
      //   370: checkcast 187	java/lang/Throwable
      //   373: ldc 188
      //   375: iconst_0
      //   376: anewarray 190	java/lang/Object
      //   379: invokestatic 196	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   382: aload_2
      //   383: ifnull +9 -> 392
      //   386: aload_2
      //   387: invokeinterface 178 1 0
      //   392: aload 7
      //   394: ifnull +16 -> 410
      //   397: aload 7
      //   399: invokeinterface 178 1 0
      //   404: ldc 62
      //   406: invokestatic 181	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   409: return
      //   410: ldc 62
      //   412: invokestatic 181	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   415: return
      //   416: astore_1
      //   417: aconst_null
      //   418: astore 5
      //   420: aconst_null
      //   421: astore_2
      //   422: aload_2
      //   423: ifnull +9 -> 432
      //   426: aload_2
      //   427: invokeinterface 178 1 0
      //   432: aload 5
      //   434: ifnull +10 -> 444
      //   437: aload 5
      //   439: invokeinterface 178 1 0
      //   444: ldc 62
      //   446: invokestatic 181	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   449: aload_1
      //   450: athrow
      //   451: astore_1
      //   452: aconst_null
      //   453: astore 5
      //   455: goto -33 -> 422
      //   458: astore_1
      //   459: aload 6
      //   461: astore_2
      //   462: goto -40 -> 422
      //   465: astore_1
      //   466: aconst_null
      //   467: astore 7
      //   469: goto -110 -> 359
      //   472: astore_1
      //   473: goto -114 -> 359
      //   476: astore_1
      //   477: aconst_null
      //   478: astore 7
      //   480: goto -184 -> 296
      //   483: astore_1
      //   484: goto -188 -> 296
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	487	0	this	b
      //   0	487	1	paramContext	Context
      //   0	487	2	paramList	List<String>
      //   1	186	3	i	int
      //   127	58	4	j	int
      //   51	403	5	localObject1	Object
      //   105	355	6	localObject2	Object
      //   209	270	7	localXmlResourceParser	android.content.res.XmlResourceParser
      // Exception table:
      //   from	to	target	type
      //   190	200	290	org/xmlpull/v1/XmlPullParserException
      //   190	200	353	java/io/IOException
      //   190	200	416	finally
      //   200	211	451	finally
      //   218	233	458	finally
      //   240	256	458	finally
      //   303	319	458	finally
      //   366	382	458	finally
      //   200	211	465	java/io/IOException
      //   218	233	472	java/io/IOException
      //   240	256	472	java/io/IOException
      //   200	211	476	org/xmlpull/v1/XmlPullParserException
      //   218	233	483	org/xmlpull/v1/XmlPullParserException
      //   240	256	483	org/xmlpull/v1/XmlPullParserException
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(119647);
      int i = this.yqb.size();
      AppMethodBeat.o(119647);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(119648);
      if (paramInt < 0)
      {
        AppMethodBeat.o(119648);
        return null;
      }
      b localb = (b)this.yqb.get(Integer.valueOf(paramInt));
      AppMethodBeat.o(119648);
      return localb;
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(119649);
      d.g.b.k.h(paramViewGroup, "parent");
      if (paramView == null)
      {
        paramView = View.inflate(this.context, 2131495716, null);
        paramViewGroup = new StoryRangeDetailUI.c();
        if (paramView == null) {
          d.g.b.k.fvU();
        }
        localObject1 = paramView.findViewById(2131298724);
        if (localObject1 == null)
        {
          paramView = new v("null cannot be cast to non-null type android.widget.TextView");
          AppMethodBeat.o(119649);
          throw paramView;
        }
        paramViewGroup.sGm = ((TextView)localObject1);
        localObject1 = paramView.findViewById(2131298721);
        if (localObject1 == null)
        {
          paramView = new v("null cannot be cast to non-null type com.tencent.mm.ui.base.MaskLayout");
          AppMethodBeat.o(119649);
          throw paramView;
        }
        paramViewGroup.fwD = ((MaskLayout)localObject1);
        localObject1 = paramView.findViewById(2131298729);
        if (localObject1 == null)
        {
          paramView = new v("null cannot be cast to non-null type android.widget.TextView");
          AppMethodBeat.o(119649);
          throw paramView;
        }
        paramViewGroup.fsI = ((TextView)localObject1);
        localObject1 = paramView.findViewById(2131298719);
        if (localObject1 == null)
        {
          paramView = new v("null cannot be cast to non-null type android.widget.TextView");
          AppMethodBeat.o(119649);
          throw paramView;
        }
        paramViewGroup.yqe = ((TextView)localObject1);
        paramView.setTag(paramViewGroup);
        getItem(paramInt);
        localObject2 = (b)getItem(paramInt);
        localObject1 = paramViewGroup.sGm;
        if (localObject1 == null) {
          d.g.b.k.fvU();
        }
        ((TextView)localObject1).setVisibility(8);
        localObject3 = paramViewGroup.fsI;
        if (localObject3 == null) {
          d.g.b.k.fvU();
        }
        if (localObject2 == null) {
          d.g.b.k.fvU();
        }
        if (w.to(((b)localObject2).getUsername())) {
          break label365;
        }
      }
      label365:
      for (Object localObject1 = this.yqc;; localObject1 = this.yqd)
      {
        ((TextView)localObject3).setTextColor((ColorStateList)localObject1);
        localObject1 = paramViewGroup.fwD;
        if (localObject1 == null) {
          d.g.b.k.fvU();
        }
        localObject1 = ((MaskLayout)localObject1).getContentView();
        if (localObject1 != null) {
          break label374;
        }
        paramView = new v("null cannot be cast to non-null type android.widget.ImageView");
        AppMethodBeat.o(119649);
        throw paramView;
        paramViewGroup = paramView.getTag();
        if (paramViewGroup == null)
        {
          paramView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.story.ui.StoryRangeDetailUI.ViewHolder");
          AppMethodBeat.o(119649);
          throw paramView;
        }
        paramViewGroup = (StoryRangeDetailUI.c)paramViewGroup;
        break;
      }
      label374:
      a.b.w((ImageView)localObject1, ((b)localObject2).getUsername());
      localObject1 = paramViewGroup.yqe;
      if (localObject1 == null) {
        d.g.b.k.fvU();
      }
      ((TextView)localObject1).setVisibility(8);
      localObject1 = paramViewGroup.fwD;
      if (localObject1 == null) {
        d.g.b.k.fvU();
      }
      ((MaskLayout)localObject1).setVisibility(0);
      localObject1 = paramViewGroup.fsI;
      if (localObject1 == null) {
        d.g.b.k.fvU();
      }
      Object localObject3 = this.context;
      Object localObject2 = (CharSequence)((b)localObject2).ZX();
      TextView localTextView = paramViewGroup.fsI;
      if (localTextView == null) {
        d.g.b.k.fvU();
      }
      ((TextView)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.b((Context)localObject3, (CharSequence)localObject2, localTextView.getTextSize()));
      paramViewGroup = paramViewGroup.fsI;
      if (paramViewGroup == null) {
        d.g.b.k.fvU();
      }
      paramViewGroup.setVisibility(0);
      AppMethodBeat.o(119649);
      return paramView;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/StoryRangeDetailUI$ViewHolder;", "", "()V", "avatarIV", "Lcom/tencent/mm/ui/base/MaskLayout;", "getAvatarIV$plugin_story_release", "()Lcom/tencent/mm/ui/base/MaskLayout;", "setAvatarIV$plugin_story_release", "(Lcom/tencent/mm/ui/base/MaskLayout;)V", "catalog", "Landroid/widget/TextView;", "getCatalog$plugin_story_release", "()Landroid/widget/TextView;", "setCatalog$plugin_story_release", "(Landroid/widget/TextView;)V", "nickTV", "getNickTV$plugin_story_release", "setNickTV$plugin_story_release", "weixinTV", "getWeixinTV$plugin_story_release", "setWeixinTV$plugin_story_release", "plugin-story_release"})
  static final class c
  {
    TextView fsI;
    MaskLayout fwD;
    TextView sGm;
    TextView yqe;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class d
    implements MenuItem.OnMenuItemClickListener
  {
    d(StoryRangeDetailUI paramStoryRangeDetailUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(119651);
      this.yqf.finish();
      AppMethodBeat.o(119651);
      return true;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "parent", "Landroid/widget/AdapterView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemClick"})
  static final class e
    implements AdapterView.OnItemClickListener
  {
    e(StoryRangeDetailUI paramStoryRangeDetailUI) {}
    
    public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      AppMethodBeat.i(119652);
      paramAdapterView = StoryRangeDetailUI.a(this.yqf);
      if (paramAdapterView != null) {}
      for (paramAdapterView = paramAdapterView.getItem(paramInt); paramAdapterView == null; paramAdapterView = null)
      {
        paramAdapterView = new v("null cannot be cast to non-null type com.tencent.mm.contact.RContact");
        AppMethodBeat.o(119652);
        throw paramAdapterView;
      }
      paramAdapterView = (b)paramAdapterView;
      paramView = new Intent();
      paramView.putExtra("Contact_User", paramAdapterView.getUsername());
      paramView.putExtra("CONTACT_INFO_UI_SOURCE", 12);
      d.b((Context)this.yqf.getContext(), "profile", ".ui.ContactInfoUI", paramView);
      AppMethodBeat.o(119652);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.StoryRangeDetailUI
 * JD-Core Version:    0.7.0.1
 */