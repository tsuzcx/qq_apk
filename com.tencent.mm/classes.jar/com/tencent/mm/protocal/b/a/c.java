package com.tencent.mm.protocal.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.akh;
import java.util.LinkedList;

public final class c
  extends com.tencent.mm.bw.a
{
  public akh FId;
  public String desc;
  public LinkedList<ajx> hFT;
  public long pWN;
  public String title;
  public String xGt;
  
  public c()
  {
    AppMethodBeat.i(94808);
    this.hFT = new LinkedList();
    AppMethodBeat.o(94808);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94809);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.d(2, this.desc);
      }
      paramVarArgs.e(3, 8, this.hFT);
      if (this.xGt != null) {
        paramVarArgs.d(4, this.xGt);
      }
      if (this.FId != null)
      {
        paramVarArgs.lJ(5, this.FId.computeSize());
        this.FId.writeFields(paramVarArgs);
      }
      paramVarArgs.aZ(6, this.pWN);
      AppMethodBeat.o(94809);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label678;
      }
    }
    label678:
    for (paramInt = f.a.a.b.b.a.e(1, this.title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.desc != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.desc);
      }
      i += f.a.a.a.c(3, 8, this.hFT);
      paramInt = i;
      if (this.xGt != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.xGt);
      }
      i = paramInt;
      if (this.FId != null) {
        i = paramInt + f.a.a.a.lI(5, this.FId.computeSize());
      }
      paramInt = f.a.a.b.b.a.p(6, this.pWN);
      AppMethodBeat.o(94809);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.hFT.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(94809);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        c localc = (c)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(94809);
          return -1;
        case 1: 
          localc.title = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(94809);
          return 0;
        case 2: 
          localc.desc = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(94809);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ajx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ajx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localc.hFT.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94809);
          return 0;
        case 4: 
          localc.xGt = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(94809);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new akh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((akh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localc.FId = ((akh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94809);
          return 0;
        }
        localc.pWN = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(94809);
        return 0;
      }
      AppMethodBeat.o(94809);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.b.a.c
 * JD-Core Version:    0.7.0.1
 */