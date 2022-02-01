package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class axw
  extends com.tencent.mm.cd.a
{
  public aza SJM;
  public String SnB;
  public int scene;
  public long seq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(230385);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(101, this.scene);
      paramVarArgs.bm(102, this.seq);
      if (this.SJM != null)
      {
        paramVarArgs.oE(103, this.SJM.computeSize());
        this.SJM.writeFields(paramVarArgs);
      }
      if (this.SnB != null) {
        paramVarArgs.f(104, this.SnB);
      }
      AppMethodBeat.o(230385);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(101, this.scene) + 0 + g.a.a.b.b.a.p(102, this.seq);
      paramInt = i;
      if (this.SJM != null) {
        paramInt = i + g.a.a.a.oD(103, this.SJM.computeSize());
      }
      i = paramInt;
      if (this.SnB != null) {
        i = paramInt + g.a.a.b.b.a.g(104, this.SnB);
      }
      AppMethodBeat.o(230385);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(230385);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      axw localaxw = (axw)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(230385);
        return -1;
      case 101: 
        localaxw.scene = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(230385);
        return 0;
      case 102: 
        localaxw.seq = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(230385);
        return 0;
      case 103: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          aza localaza = new aza();
          if ((localObject != null) && (localObject.length > 0)) {
            localaza.parseFrom((byte[])localObject);
          }
          localaxw.SJM = localaza;
          paramInt += 1;
        }
        AppMethodBeat.o(230385);
        return 0;
      }
      localaxw.SnB = ((g.a.a.a.a)localObject).abFh.readString();
      AppMethodBeat.o(230385);
      return 0;
    }
    AppMethodBeat.o(230385);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axw
 * JD-Core Version:    0.7.0.1
 */