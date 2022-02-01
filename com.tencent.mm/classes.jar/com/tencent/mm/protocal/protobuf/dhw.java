package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dhw
  extends com.tencent.mm.bw.a
{
  public long HPc;
  public long HPd;
  public long HPe;
  public LinkedList<dgo> HPf;
  public String HPg;
  public String dAa;
  public String dyf;
  public String hLz;
  
  public dhw()
  {
    AppMethodBeat.i(122548);
    this.HPc = 0L;
    this.HPd = 0L;
    this.HPe = 0L;
    this.HPf = new LinkedList();
    AppMethodBeat.o(122548);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122549);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dAa != null) {
        paramVarArgs.d(1, this.dAa);
      }
      paramVarArgs.aZ(2, this.HPc);
      paramVarArgs.aZ(3, this.HPd);
      paramVarArgs.aZ(4, this.HPe);
      paramVarArgs.e(5, 8, this.HPf);
      if (this.dyf != null) {
        paramVarArgs.d(6, this.dyf);
      }
      if (this.hLz != null) {
        paramVarArgs.d(7, this.hLz);
      }
      if (this.HPg != null) {
        paramVarArgs.d(8, this.HPg);
      }
      AppMethodBeat.o(122549);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dAa == null) {
        break label670;
      }
    }
    label670:
    for (paramInt = f.a.a.b.b.a.e(1, this.dAa) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.HPc) + f.a.a.b.b.a.p(3, this.HPd) + f.a.a.b.b.a.p(4, this.HPe) + f.a.a.a.c(5, 8, this.HPf);
      paramInt = i;
      if (this.dyf != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.dyf);
      }
      i = paramInt;
      if (this.hLz != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.hLz);
      }
      paramInt = i;
      if (this.HPg != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.HPg);
      }
      AppMethodBeat.o(122549);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HPf.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(122549);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dhw localdhw = (dhw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122549);
          return -1;
        case 1: 
          localdhw.dAa = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(122549);
          return 0;
        case 2: 
          localdhw.HPc = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(122549);
          return 0;
        case 3: 
          localdhw.HPd = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(122549);
          return 0;
        case 4: 
          localdhw.HPe = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(122549);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dgo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dgo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdhw.HPf.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122549);
          return 0;
        case 6: 
          localdhw.dyf = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(122549);
          return 0;
        case 7: 
          localdhw.hLz = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(122549);
          return 0;
        }
        localdhw.HPg = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(122549);
        return 0;
      }
      AppMethodBeat.o(122549);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhw
 * JD-Core Version:    0.7.0.1
 */