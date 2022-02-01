package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class dnk
  extends com.tencent.mm.bw.a
{
  public ehb GwL;
  public long HUv;
  public long HUw;
  public long HUx;
  public long HUy;
  public LinkedList<b> HUz;
  public long begin_time;
  public long duration;
  public String text;
  
  public dnk()
  {
    AppMethodBeat.i(110911);
    this.HUz = new LinkedList();
    AppMethodBeat.o(110911);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110912);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GwL != null)
      {
        paramVarArgs.lJ(1, this.GwL.computeSize());
        this.GwL.writeFields(paramVarArgs);
      }
      paramVarArgs.aZ(2, this.begin_time);
      paramVarArgs.aZ(3, this.duration);
      if (this.text != null) {
        paramVarArgs.d(4, this.text);
      }
      paramVarArgs.aZ(5, this.HUv);
      paramVarArgs.aZ(6, this.HUw);
      paramVarArgs.aZ(7, this.HUx);
      paramVarArgs.aZ(8, this.HUy);
      paramVarArgs.e(9, 6, this.HUz);
      AppMethodBeat.o(110912);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GwL == null) {
        break label710;
      }
    }
    label710:
    for (paramInt = f.a.a.a.lI(1, this.GwL.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.begin_time) + f.a.a.b.b.a.p(3, this.duration);
      paramInt = i;
      if (this.text != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.text);
      }
      i = f.a.a.b.b.a.p(5, this.HUv);
      int j = f.a.a.b.b.a.p(6, this.HUw);
      int k = f.a.a.b.b.a.p(7, this.HUx);
      int m = f.a.a.b.b.a.p(8, this.HUy);
      int n = f.a.a.a.c(9, 6, this.HUz);
      AppMethodBeat.o(110912);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HUz.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(110912);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dnk localdnk = (dnk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(110912);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ehb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ehb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdnk.GwL = ((ehb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(110912);
          return 0;
        case 2: 
          localdnk.begin_time = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(110912);
          return 0;
        case 3: 
          localdnk.duration = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(110912);
          return 0;
        case 4: 
          localdnk.text = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(110912);
          return 0;
        case 5: 
          localdnk.HUv = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(110912);
          return 0;
        case 6: 
          localdnk.HUw = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(110912);
          return 0;
        case 7: 
          localdnk.HUx = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(110912);
          return 0;
        case 8: 
          localdnk.HUy = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(110912);
          return 0;
        }
        localdnk.HUz.add(((f.a.a.a.a)localObject1).OmT.gCk());
        AppMethodBeat.o(110912);
        return 0;
      }
      AppMethodBeat.o(110912);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dnk
 * JD-Core Version:    0.7.0.1
 */