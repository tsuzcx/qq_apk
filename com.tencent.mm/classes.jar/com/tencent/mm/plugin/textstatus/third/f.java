package com.tencent.mm.plugin.textstatus.third;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.a.d;
import com.tencent.mm.plugin.textstatus.a.k;
import com.tencent.mm.plugin.textstatus.proto.au;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/third/MixCustomElements;", "Lcom/tencent/mm/plugin/textstatus/api/IMixStatusCustomElements;", "()V", "jumpElementParts", "", "", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCustomParts;", "getJumpElementParts", "()Ljava/util/Map;", "setJumpElementParts", "(Ljava/util/Map;)V", "jumpElements", "", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpElement;", "getJumpElements", "()Ljava/util/List;", "setJumpElements", "(Ljava/util/List;)V", "textStatusID", "getTextStatusID", "()Ljava/lang/String;", "setTextStatusID", "(Ljava/lang/String;)V", "getElement", "elementType", "", "elementKey", "onAttach", "", "", "onDetach", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends d
{
  private List<? extends au> TuO;
  private String TuP;
  private Map<String, k> TuQ;
  
  public f()
  {
    AppMethodBeat.i(290087);
    this.TuP = "";
    this.TuQ = ((Map)new HashMap());
    AppMethodBeat.o(290087);
  }
  
  public final k bdo(String paramString)
  {
    AppMethodBeat.i(290103);
    s.u(paramString, "elementKey");
    paramString = "1_".concat(String.valueOf(paramString));
    paramString = (k)this.TuQ.get(paramString);
    AppMethodBeat.o(290103);
    return paramString;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(290109);
    Iterator localIterator = this.TuQ.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((k)((Map.Entry)localIterator.next()).getValue()).onDetach();
    }
    this.TuQ.clear();
    AppMethodBeat.o(290109);
  }
  
  /* Error */
  public final void y(String paramString, List<au> paramList)
  {
    // Byte code:
    //   0: ldc 135
    //   2: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: aload_2
    //   7: putfield 137	com/tencent/mm/plugin/textstatus/third/f:TuO	Ljava/util/List;
    //   10: aload_0
    //   11: aload_1
    //   12: putfield 62	com/tencent/mm/plugin/textstatus/third/f:TuP	Ljava/lang/String;
    //   15: aload_0
    //   16: getfield 69	com/tencent/mm/plugin/textstatus/third/f:TuQ	Ljava/util/Map;
    //   19: invokeinterface 132 1 0
    //   24: aload_2
    //   25: ifnull +166 -> 191
    //   28: aload_2
    //   29: checkcast 139	java/lang/Iterable
    //   32: invokeinterface 140 1 0
    //   37: astore_3
    //   38: aload_3
    //   39: invokeinterface 118 1 0
    //   44: ifeq +147 -> 191
    //   47: aload_3
    //   48: invokeinterface 122 1 0
    //   53: checkcast 142	com/tencent/mm/plugin/textstatus/proto/au
    //   56: astore 4
    //   58: aload 4
    //   60: getfield 146	com/tencent/mm/plugin/textstatus/proto/au:jumpInfos	Ljava/util/LinkedList;
    //   63: astore_2
    //   64: aload_2
    //   65: ldc 148
    //   67: invokestatic 151	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   70: aload_2
    //   71: checkcast 153	java/util/List
    //   74: invokestatic 159	com/tencent/mm/plugin/textstatus/third/j:lu	(Ljava/util/List;)Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;
    //   77: astore_2
    //   78: getstatic 165	com/tencent/mm/plugin/textstatus/third/i:TuX	Lcom/tencent/mm/plugin/textstatus/third/i;
    //   81: astore 5
    //   83: aload_2
    //   84: ifnonnull +99 -> 183
    //   87: aconst_null
    //   88: astore_2
    //   89: aload_2
    //   90: invokestatic 168	com/tencent/mm/plugin/textstatus/third/i:bed	(Ljava/lang/String;)Lcom/tencent/mm/plugin/textstatus/a/k;
    //   93: astore_2
    //   94: aload_2
    //   95: ifnull -57 -> 38
    //   98: aload_2
    //   99: aload_1
    //   100: aload 4
    //   102: getfield 146	com/tencent/mm/plugin/textstatus/proto/au:jumpInfos	Ljava/util/LinkedList;
    //   105: checkcast 153	java/util/List
    //   108: invokevirtual 170	com/tencent/mm/plugin/textstatus/a/k:y	(Ljava/lang/String;Ljava/util/List;)V
    //   111: aload_0
    //   112: getfield 69	com/tencent/mm/plugin/textstatus/third/f:TuQ	Ljava/util/Map;
    //   115: astore 5
    //   117: aload 4
    //   119: ldc 172
    //   121: invokestatic 83	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   124: aload 5
    //   126: new 174	java/lang/StringBuilder
    //   129: dup
    //   130: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   133: aload 4
    //   135: getfield 179	com/tencent/mm/plugin/textstatus/proto/au:TpY	I
    //   138: invokevirtual 183	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   141: bipush 95
    //   143: invokevirtual 186	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   146: aload 4
    //   148: getfield 189	com/tencent/mm/plugin/textstatus/proto/au:TpZ	Ljava/lang/String;
    //   151: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   154: invokevirtual 195	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: aload_2
    //   158: invokeinterface 199 3 0
    //   163: pop
    //   164: goto -126 -> 38
    //   167: astore_2
    //   168: ldc 201
    //   170: aload_2
    //   171: ldc 203
    //   173: iconst_0
    //   174: anewarray 205	java/lang/Object
    //   177: invokestatic 211	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   180: goto -142 -> 38
    //   183: aload_2
    //   184: getfield 216	com/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo:jumpType	Ljava/lang/String;
    //   187: astore_2
    //   188: goto -99 -> 89
    //   191: ldc 135
    //   193: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   196: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	this	f
    //   0	197	1	paramString	String
    //   0	197	2	paramList	List<au>
    //   37	11	3	localIterator	Iterator
    //   56	91	4	localau	au
    //   81	44	5	localObject	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   98	164	167	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.third.f
 * JD-Core Version:    0.7.0.1
 */