package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class alw
  extends com.tencent.mm.bw.a
{
  public int GEk;
  public b GEl;
  public int GEm;
  public zd GEn;
  public int scene;
  public long xsF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168937);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.GEk);
      paramVarArgs.aS(2, this.scene);
      if (this.GEl != null) {
        paramVarArgs.c(3, this.GEl);
      }
      paramVarArgs.aS(4, this.GEm);
      if (this.GEn != null)
      {
        paramVarArgs.lJ(5, this.GEn.computeSize());
        this.GEn.writeFields(paramVarArgs);
      }
      paramVarArgs.aZ(6, this.xsF);
      AppMethodBeat.o(168937);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.GEk) + 0 + f.a.a.b.b.a.bz(2, this.scene);
      paramInt = i;
      if (this.GEl != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.GEl);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.GEm);
      paramInt = i;
      if (this.GEn != null) {
        paramInt = i + f.a.a.a.lI(5, this.GEn.computeSize());
      }
      i = f.a.a.b.b.a.p(6, this.xsF);
      AppMethodBeat.o(168937);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(168937);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      alw localalw = (alw)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(168937);
        return -1;
      case 1: 
        localalw.GEk = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(168937);
        return 0;
      case 2: 
        localalw.scene = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(168937);
        return 0;
      case 3: 
        localalw.GEl = ((f.a.a.a.a)localObject1).OmT.gCk();
        AppMethodBeat.o(168937);
        return 0;
      case 4: 
        localalw.GEm = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(168937);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new zd();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((zd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localalw.GEn = ((zd)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(168937);
        return 0;
      }
      localalw.xsF = ((f.a.a.a.a)localObject1).OmT.zd();
      AppMethodBeat.o(168937);
      return 0;
    }
    AppMethodBeat.o(168937);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.alw
 * JD-Core Version:    0.7.0.1
 */