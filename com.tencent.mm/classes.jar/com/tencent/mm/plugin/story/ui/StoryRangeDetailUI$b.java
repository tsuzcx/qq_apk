package com.tencent.mm.plugin.story.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.contact.d;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.story.a.d;
import com.tencent.mm.plugin.story.a.e;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.base.MaskLayout;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/StoryRangeDetailUI$ContactsAdapter;", "Landroid/widget/BaseAdapter;", "context", "Landroid/content/Context;", "userNames", "", "", "(Landroid/content/Context;Ljava/util/List;)V", "cstg", "Lcom/tencent/mm/storage/IContactStorage;", "list", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/contact/RContact;", "normal", "Landroid/content/res/ColorStateList;", "spuser", "getCount", "getItem", "", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
final class StoryRangeDetailUI$b
  extends BaseAdapter
{
  private bx RoL;
  private final HashMap<Integer, d> StU;
  private ColorStateList StV;
  private ColorStateList StW;
  private Context context;
  
  /* Error */
  public StoryRangeDetailUI$b(Context paramContext, java.util.List<java.lang.String> paramList)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_1
    //   3: ldc 54
    //   5: invokestatic 60	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   8: aload_2
    //   9: ldc 61
    //   11: invokestatic 60	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   14: aload_0
    //   15: invokespecial 64	android/widget/BaseAdapter:<init>	()V
    //   18: ldc 65
    //   20: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   23: aload_0
    //   24: aload_1
    //   25: putfield 73	com/tencent/mm/plugin/story/ui/StoryRangeDetailUI$b:context	Landroid/content/Context;
    //   28: aload_0
    //   29: new 75	java/util/HashMap
    //   32: dup
    //   33: invokespecial 76	java/util/HashMap:<init>	()V
    //   36: putfield 78	com/tencent/mm/plugin/story/ui/StoryRangeDetailUI$b:StU	Ljava/util/HashMap;
    //   39: aload_0
    //   40: getfield 78	com/tencent/mm/plugin/story/ui/StoryRangeDetailUI$b:StU	Ljava/util/HashMap;
    //   43: invokevirtual 81	java/util/HashMap:clear	()V
    //   46: aload_0
    //   47: ldc 83
    //   49: invokestatic 89	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   52: checkcast 83	com/tencent/mm/plugin/messenger/foundation/a/n
    //   55: invokeinterface 93 1 0
    //   60: putfield 95	com/tencent/mm/plugin/story/ui/StoryRangeDetailUI$b:RoL	Lcom/tencent/mm/storage/bx;
    //   63: aload_2
    //   64: invokeinterface 101 1 0
    //   69: astore_2
    //   70: aload_2
    //   71: invokeinterface 107 1 0
    //   76: ifeq +86 -> 162
    //   79: aload_2
    //   80: invokeinterface 111 1 0
    //   85: checkcast 113	java/lang/String
    //   88: astore 4
    //   90: aload_0
    //   91: getfield 95	com/tencent/mm/plugin/story/ui/StoryRangeDetailUI$b:RoL	Lcom/tencent/mm/storage/bx;
    //   94: astore 5
    //   96: aload 5
    //   98: invokestatic 117	kotlin/g/b/s:checkNotNull	(Ljava/lang/Object;)V
    //   101: aload 5
    //   103: aload 4
    //   105: invokeinterface 123 2 0
    //   110: astore 5
    //   112: aload 5
    //   114: ifnull -44 -> 70
    //   117: aload 5
    //   119: getfield 129	com/tencent/mm/autogen/b/az:field_type	I
    //   122: invokestatic 135	com/tencent/mm/contact/d:rs	(I)Z
    //   125: ifeq -55 -> 70
    //   128: aload 4
    //   130: invokestatic 141	com/tencent/mm/model/z:Iy	(Ljava/lang/String;)Z
    //   133: ifne -63 -> 70
    //   136: aload_0
    //   137: getfield 78	com/tencent/mm/plugin/story/ui/StoryRangeDetailUI$b:StU	Ljava/util/HashMap;
    //   140: checkcast 143	java/util/Map
    //   143: iload_3
    //   144: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   147: aload 5
    //   149: invokeinterface 153 3 0
    //   154: pop
    //   155: iload_3
    //   156: iconst_1
    //   157: iadd
    //   158: istore_3
    //   159: goto -89 -> 70
    //   162: aload_1
    //   163: invokevirtual 159	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   166: getstatic 164	com/tencent/mm/plugin/story/a$a:mm_list_textcolor_one	I
    //   169: invokevirtual 170	android/content/res/Resources:getXml	(I)Landroid/content/res/XmlResourceParser;
    //   172: astore_2
    //   173: aload_1
    //   174: invokevirtual 159	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   177: getstatic 173	com/tencent/mm/plugin/story/a$a:mm_list_textcolor_spuser	I
    //   180: invokevirtual 170	android/content/res/Resources:getXml	(I)Landroid/content/res/XmlResourceParser;
    //   183: astore 6
    //   185: aload_2
    //   186: astore 5
    //   188: aload 6
    //   190: astore 4
    //   192: aload_0
    //   193: aload_1
    //   194: invokevirtual 159	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   197: aload_2
    //   198: checkcast 175	org/xmlpull/v1/XmlPullParser
    //   201: invokestatic 181	android/content/res/ColorStateList:createFromXml	(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;)Landroid/content/res/ColorStateList;
    //   204: putfield 183	com/tencent/mm/plugin/story/ui/StoryRangeDetailUI$b:StV	Landroid/content/res/ColorStateList;
    //   207: aload_2
    //   208: astore 5
    //   210: aload 6
    //   212: astore 4
    //   214: aload_0
    //   215: aload_1
    //   216: invokevirtual 159	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   219: aload 6
    //   221: checkcast 175	org/xmlpull/v1/XmlPullParser
    //   224: invokestatic 181	android/content/res/ColorStateList:createFromXml	(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;)Landroid/content/res/ColorStateList;
    //   227: putfield 185	com/tencent/mm/plugin/story/ui/StoryRangeDetailUI$b:StW	Landroid/content/res/ColorStateList;
    //   230: aload_2
    //   231: ifnull +9 -> 240
    //   234: aload_2
    //   235: invokeinterface 190 1 0
    //   240: aload 6
    //   242: ifnull +10 -> 252
    //   245: aload 6
    //   247: invokeinterface 190 1 0
    //   252: ldc 65
    //   254: invokestatic 193	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   257: return
    //   258: astore_1
    //   259: aconst_null
    //   260: astore 6
    //   262: aconst_null
    //   263: astore_2
    //   264: aload_2
    //   265: astore 5
    //   267: aload 6
    //   269: astore 4
    //   271: invokestatic 197	com/tencent/mm/plugin/story/ui/StoryRangeDetailUI:access$getTAG$cp	()Ljava/lang/String;
    //   274: aload_1
    //   275: checkcast 199	java/lang/Throwable
    //   278: ldc 200
    //   280: iconst_0
    //   281: anewarray 202	java/lang/Object
    //   284: invokestatic 208	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   287: aload_2
    //   288: ifnull +9 -> 297
    //   291: aload_2
    //   292: invokeinterface 190 1 0
    //   297: aload 6
    //   299: ifnull +10 -> 309
    //   302: aload 6
    //   304: invokeinterface 190 1 0
    //   309: ldc 65
    //   311: invokestatic 193	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   314: return
    //   315: astore_1
    //   316: aconst_null
    //   317: astore 6
    //   319: aconst_null
    //   320: astore_2
    //   321: aload_2
    //   322: astore 5
    //   324: aload 6
    //   326: astore 4
    //   328: invokestatic 197	com/tencent/mm/plugin/story/ui/StoryRangeDetailUI:access$getTAG$cp	()Ljava/lang/String;
    //   331: aload_1
    //   332: checkcast 199	java/lang/Throwable
    //   335: ldc 200
    //   337: iconst_0
    //   338: anewarray 202	java/lang/Object
    //   341: invokestatic 208	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   344: aload_2
    //   345: ifnull +9 -> 354
    //   348: aload_2
    //   349: invokeinterface 190 1 0
    //   354: aload 6
    //   356: ifnull +10 -> 366
    //   359: aload 6
    //   361: invokeinterface 190 1 0
    //   366: ldc 65
    //   368: invokestatic 193	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   371: return
    //   372: astore_1
    //   373: aconst_null
    //   374: astore 4
    //   376: aconst_null
    //   377: astore_2
    //   378: aload_2
    //   379: ifnull +9 -> 388
    //   382: aload_2
    //   383: invokeinterface 190 1 0
    //   388: aload 4
    //   390: ifnull +10 -> 400
    //   393: aload 4
    //   395: invokeinterface 190 1 0
    //   400: ldc 65
    //   402: invokestatic 193	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   405: aload_1
    //   406: athrow
    //   407: astore_1
    //   408: aconst_null
    //   409: astore 4
    //   411: goto -33 -> 378
    //   414: astore_1
    //   415: aload 5
    //   417: astore_2
    //   418: goto -40 -> 378
    //   421: astore_1
    //   422: aconst_null
    //   423: astore 6
    //   425: goto -104 -> 321
    //   428: astore_1
    //   429: goto -108 -> 321
    //   432: astore_1
    //   433: aconst_null
    //   434: astore 6
    //   436: goto -172 -> 264
    //   439: astore_1
    //   440: goto -176 -> 264
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	443	0	this	b
    //   0	443	1	paramContext	Context
    //   0	443	2	paramList	java.util.List<java.lang.String>
    //   1	158	3	i	int
    //   88	322	4	localObject1	Object
    //   94	322	5	localObject2	Object
    //   183	252	6	localXmlResourceParser	android.content.res.XmlResourceParser
    // Exception table:
    //   from	to	target	type
    //   162	173	258	org/xmlpull/v1/XmlPullParserException
    //   162	173	315	java/io/IOException
    //   162	173	372	finally
    //   173	185	407	finally
    //   192	207	414	finally
    //   214	230	414	finally
    //   271	287	414	finally
    //   328	344	414	finally
    //   173	185	421	java/io/IOException
    //   192	207	428	java/io/IOException
    //   214	230	428	java/io/IOException
    //   173	185	432	org/xmlpull/v1/XmlPullParserException
    //   192	207	439	org/xmlpull/v1/XmlPullParserException
    //   214	230	439	org/xmlpull/v1/XmlPullParserException
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(119647);
    int i = this.StU.size();
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
    d locald = (d)this.StU.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(119648);
    return locald;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(119649);
    s.u(paramViewGroup, "parent");
    if (paramView == null)
    {
      paramView = View.inflate(this.context, a.e.SgX, null);
      paramViewGroup = new StoryRangeDetailUI.c();
      s.checkNotNull(paramView);
      localObject1 = paramView.findViewById(a.d.contactitem_catalog);
      if (localObject1 == null)
      {
        paramView = new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(119649);
        throw paramView;
      }
      paramViewGroup.JMf = ((TextView)localObject1);
      localObject1 = paramView.findViewById(a.d.fDl);
      if (localObject1 == null)
      {
        paramView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.MaskLayout");
        AppMethodBeat.o(119649);
        throw paramView;
      }
      paramViewGroup.lNy = ((MaskLayout)localObject1);
      localObject1 = paramView.findViewById(a.d.fDq);
      if (localObject1 == null)
      {
        paramView = new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(119649);
        throw paramView;
      }
      paramViewGroup.lDe = ((TextView)localObject1);
      localObject1 = paramView.findViewById(a.d.fDj);
      if (localObject1 == null)
      {
        paramView = new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(119649);
        throw paramView;
      }
      paramViewGroup.StX = ((TextView)localObject1);
      paramView.setTag(paramViewGroup);
      getItem(paramInt);
      localObject2 = (d)getItem(paramInt);
      localObject1 = paramViewGroup.JMf;
      s.checkNotNull(localObject1);
      ((TextView)localObject1).setVisibility(8);
      localObject3 = paramViewGroup.lDe;
      s.checkNotNull(localObject3);
      s.checkNotNull(localObject2);
      if (ab.IV(((az)localObject2).field_username)) {
        break label355;
      }
    }
    label355:
    for (Object localObject1 = this.StV;; localObject1 = this.StW)
    {
      ((TextView)localObject3).setTextColor((ColorStateList)localObject1);
      localObject1 = paramViewGroup.lNy;
      s.checkNotNull(localObject1);
      localObject1 = ((MaskLayout)localObject1).getContentView();
      if (localObject1 != null) {
        break label364;
      }
      paramView = new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(119649);
      throw paramView;
      paramViewGroup = paramView.getTag();
      if (paramViewGroup == null)
      {
        paramView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.story.ui.StoryRangeDetailUI.ViewHolder");
        AppMethodBeat.o(119649);
        throw paramView;
      }
      paramViewGroup = (StoryRangeDetailUI.c)paramViewGroup;
      break;
    }
    label364:
    a.b.C((ImageView)localObject1, ((az)localObject2).field_username);
    localObject1 = paramViewGroup.StX;
    s.checkNotNull(localObject1);
    ((TextView)localObject1).setVisibility(8);
    localObject1 = paramViewGroup.lNy;
    s.checkNotNull(localObject1);
    ((MaskLayout)localObject1).setVisibility(0);
    localObject1 = paramViewGroup.lDe;
    s.checkNotNull(localObject1);
    Object localObject3 = this.context;
    Object localObject2 = (CharSequence)((d)localObject2).aSV();
    TextView localTextView = paramViewGroup.lDe;
    s.checkNotNull(localTextView);
    ((TextView)localObject1).setText((CharSequence)p.b((Context)localObject3, (CharSequence)localObject2, localTextView.getTextSize()));
    paramViewGroup = paramViewGroup.lDe;
    s.checkNotNull(paramViewGroup);
    paramViewGroup.setVisibility(0);
    AppMethodBeat.o(119649);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.StoryRangeDetailUI.b
 * JD-Core Version:    0.7.0.1
 */