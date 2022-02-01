package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cfj
  extends com.tencent.mm.bw.a
{
  public int GFG;
  public int GUx;
  public cfl GUy;
  public int Hsb;
  public cfk Hsc;
  public int Hsd;
  public int Hse;
  public int Hsf;
  public String app_id;
  public String iKu;
  public int vWf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152631);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.iKu != null) {
        paramVarArgs.d(1, this.iKu);
      }
      paramVarArgs.aS(2, this.Hsb);
      if (this.Hsc != null)
      {
        paramVarArgs.lJ(3, this.Hsc.computeSize());
        this.Hsc.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(4, this.GUx);
      if (this.GUy != null)
      {
        paramVarArgs.lJ(5, this.GUy.computeSize());
        this.GUy.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(6, this.Hsd);
      paramVarArgs.aS(7, this.Hse);
      paramVarArgs.aS(8, this.vWf);
      paramVarArgs.aS(9, this.Hsf);
      if (this.app_id != null) {
        paramVarArgs.d(10, this.app_id);
      }
      paramVarArgs.aS(11, this.GFG);
      AppMethodBeat.o(152631);
      return 0;
    }
    if (paramInt == 1) {
      if (this.iKu == null) {
        break label898;
      }
    }
    label898:
    for (paramInt = f.a.a.b.b.a.e(1, this.iKu) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.Hsb);
      paramInt = i;
      if (this.Hsc != null) {
        paramInt = i + f.a.a.a.lI(3, this.Hsc.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.GUx);
      paramInt = i;
      if (this.GUy != null) {
        paramInt = i + f.a.a.a.lI(5, this.GUy.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.Hsd) + f.a.a.b.b.a.bz(7, this.Hse) + f.a.a.b.b.a.bz(8, this.vWf) + f.a.a.b.b.a.bz(9, this.Hsf);
      paramInt = i;
      if (this.app_id != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.app_id);
      }
      i = f.a.a.b.b.a.bz(11, this.GFG);
      AppMethodBeat.o(152631);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(152631);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cfj localcfj = (cfj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152631);
          return -1;
        case 1: 
          localcfj.iKu = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152631);
          return 0;
        case 2: 
          localcfj.Hsb = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152631);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cfk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cfk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcfj.Hsc = ((cfk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152631);
          return 0;
        case 4: 
          localcfj.GUx = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152631);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cfl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cfl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcfj.GUy = ((cfl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152631);
          return 0;
        case 6: 
          localcfj.Hsd = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152631);
          return 0;
        case 7: 
          localcfj.Hse = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152631);
          return 0;
        case 8: 
          localcfj.vWf = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152631);
          return 0;
        case 9: 
          localcfj.Hsf = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152631);
          return 0;
        case 10: 
          localcfj.app_id = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152631);
          return 0;
        }
        localcfj.GFG = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(152631);
        return 0;
      }
      AppMethodBeat.o(152631);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cfj
 * JD-Core Version:    0.7.0.1
 */