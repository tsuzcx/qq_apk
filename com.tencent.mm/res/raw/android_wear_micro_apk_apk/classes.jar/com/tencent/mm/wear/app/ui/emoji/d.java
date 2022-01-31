package com.tencent.mm.wear.app.ui.emoji;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.LinkedList;

public final class d
  extends BaseAdapter
{
  private LinkedList<e> afF;
  private boolean afG;
  private Context context;
  
  /* Error */
  public d(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 16	android/widget/BaseAdapter:<init>	()V
    //   4: aload_0
    //   5: new 18	java/util/LinkedList
    //   8: dup
    //   9: invokespecial 19	java/util/LinkedList:<init>	()V
    //   12: putfield 21	com/tencent/mm/wear/app/ui/emoji/d:afF	Ljava/util/LinkedList;
    //   15: aload_0
    //   16: aload_1
    //   17: putfield 23	com/tencent/mm/wear/app/ui/emoji/d:context	Landroid/content/Context;
    //   20: aload_1
    //   21: ldc 25
    //   23: invokevirtual 31	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   26: checkcast 33	android/hardware/SensorManager
    //   29: bipush 21
    //   31: invokevirtual 37	android/hardware/SensorManager:getDefaultSensor	(I)Landroid/hardware/Sensor;
    //   34: ifnull +168 -> 202
    //   37: aload_0
    //   38: iconst_1
    //   39: putfield 39	com/tencent/mm/wear/app/ui/emoji/d:afG	Z
    //   42: new 41	com/tencent/mm/wear/app/ui/emoji/e
    //   45: dup
    //   46: aload_0
    //   47: invokespecial 44	com/tencent/mm/wear/app/ui/emoji/e:<init>	(Lcom/tencent/mm/wear/app/ui/emoji/d;)V
    //   50: astore_3
    //   51: aload_3
    //   52: ldc 45
    //   54: putfield 49	com/tencent/mm/wear/app/ui/emoji/e:afH	I
    //   57: aload_3
    //   58: aload_1
    //   59: ldc 50
    //   61: invokevirtual 54	android/content/Context:getString	(I)Ljava/lang/String;
    //   64: putfield 58	com/tencent/mm/wear/app/ui/emoji/e:afI	Ljava/lang/String;
    //   67: aload_3
    //   68: ldc 60
    //   70: putfield 63	com/tencent/mm/wear/app/ui/emoji/e:afs	Ljava/lang/String;
    //   73: aload_3
    //   74: ldc 64
    //   76: putfield 67	com/tencent/mm/wear/app/ui/emoji/e:afJ	I
    //   79: aload_0
    //   80: getfield 21	com/tencent/mm/wear/app/ui/emoji/d:afF	Ljava/util/LinkedList;
    //   83: aload_3
    //   84: invokevirtual 71	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   87: pop
    //   88: aload_1
    //   89: invokevirtual 75	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   92: ldc 76
    //   94: invokevirtual 82	android/content/res/Resources:getStringArray	(I)[Ljava/lang/String;
    //   97: astore 5
    //   99: aload_1
    //   100: invokevirtual 75	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   103: ldc 83
    //   105: invokevirtual 82	android/content/res/Resources:getStringArray	(I)[Ljava/lang/String;
    //   108: astore 6
    //   110: aload_1
    //   111: invokevirtual 75	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   114: ldc 84
    //   116: invokevirtual 88	android/content/res/Resources:obtainTypedArray	(I)Landroid/content/res/TypedArray;
    //   119: astore 4
    //   121: aload_1
    //   122: invokevirtual 75	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   125: ldc 89
    //   127: invokevirtual 88	android/content/res/Resources:obtainTypedArray	(I)Landroid/content/res/TypedArray;
    //   130: astore_3
    //   131: iconst_0
    //   132: istore_2
    //   133: iload_2
    //   134: aload 5
    //   136: arraylength
    //   137: if_icmpge +73 -> 210
    //   140: new 41	com/tencent/mm/wear/app/ui/emoji/e
    //   143: dup
    //   144: aload_0
    //   145: invokespecial 44	com/tencent/mm/wear/app/ui/emoji/e:<init>	(Lcom/tencent/mm/wear/app/ui/emoji/d;)V
    //   148: astore_1
    //   149: aload_1
    //   150: aload 4
    //   152: iload_2
    //   153: iconst_0
    //   154: invokevirtual 95	android/content/res/TypedArray:getResourceId	(II)I
    //   157: putfield 49	com/tencent/mm/wear/app/ui/emoji/e:afH	I
    //   160: aload_1
    //   161: aload 5
    //   163: iload_2
    //   164: aaload
    //   165: putfield 58	com/tencent/mm/wear/app/ui/emoji/e:afI	Ljava/lang/String;
    //   168: aload_1
    //   169: aload 6
    //   171: iload_2
    //   172: aaload
    //   173: putfield 63	com/tencent/mm/wear/app/ui/emoji/e:afs	Ljava/lang/String;
    //   176: aload_1
    //   177: aload_3
    //   178: iload_2
    //   179: iconst_0
    //   180: invokevirtual 95	android/content/res/TypedArray:getResourceId	(II)I
    //   183: putfield 67	com/tencent/mm/wear/app/ui/emoji/e:afJ	I
    //   186: aload_0
    //   187: getfield 21	com/tencent/mm/wear/app/ui/emoji/d:afF	Ljava/util/LinkedList;
    //   190: aload_1
    //   191: invokevirtual 71	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   194: pop
    //   195: iload_2
    //   196: iconst_1
    //   197: iadd
    //   198: istore_2
    //   199: goto -66 -> 133
    //   202: aload_0
    //   203: iconst_0
    //   204: putfield 39	com/tencent/mm/wear/app/ui/emoji/d:afG	Z
    //   207: goto -119 -> 88
    //   210: aload 4
    //   212: ifnull +8 -> 220
    //   215: aload 4
    //   217: invokevirtual 98	android/content/res/TypedArray:recycle	()V
    //   220: aload_3
    //   221: ifnull +7 -> 228
    //   224: aload_3
    //   225: invokevirtual 98	android/content/res/TypedArray:recycle	()V
    //   228: return
    //   229: astore_1
    //   230: aconst_null
    //   231: astore_3
    //   232: aconst_null
    //   233: astore 4
    //   235: aload 4
    //   237: ifnull +8 -> 245
    //   240: aload 4
    //   242: invokevirtual 98	android/content/res/TypedArray:recycle	()V
    //   245: aload_3
    //   246: ifnull +7 -> 253
    //   249: aload_3
    //   250: invokevirtual 98	android/content/res/TypedArray:recycle	()V
    //   253: aload_1
    //   254: athrow
    //   255: astore_1
    //   256: aconst_null
    //   257: astore_3
    //   258: goto -23 -> 235
    //   261: astore_1
    //   262: goto -27 -> 235
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	265	0	this	d
    //   0	265	1	paramContext	Context
    //   132	67	2	i	int
    //   50	208	3	localObject	Object
    //   119	122	4	localTypedArray	android.content.res.TypedArray
    //   97	65	5	arrayOfString1	java.lang.String[]
    //   108	62	6	arrayOfString2	java.lang.String[]
    // Exception table:
    //   from	to	target	type
    //   110	121	229	finally
    //   121	131	255	finally
    //   133	195	261	finally
  }
  
  public final e bX(int paramInt)
  {
    return (e)this.afF.get(paramInt);
  }
  
  public final int getCount()
  {
    return this.afF.size();
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView != null)
    {
      localObject = (f)paramView.getTag();
      paramViewGroup = paramView;
    }
    for (paramView = (View)localObject;; paramView = new f(paramViewGroup))
    {
      localObject = (e)this.afF.get(paramInt);
      paramView.aeA.setImageResource(((e)localObject).afH);
      paramView.afL.setText(((e)localObject).afI);
      if (((e)localObject).afJ > 0) {
        paramView.afM.setBackgroundResource(((e)localObject).afJ);
      }
      paramView.position = paramInt;
      return paramViewGroup;
      paramViewGroup = LayoutInflater.from(this.context).inflate(2130903051, paramViewGroup, false);
    }
  }
  
  public final boolean nn()
  {
    return this.afG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.emoji.d
 * JD-Core Version:    0.7.0.1
 */