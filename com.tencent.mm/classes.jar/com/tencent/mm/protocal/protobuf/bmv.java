package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bmv
  extends com.tencent.mm.bx.a
{
  public String DKi;
  public boolean DKj;
  public hw DKk;
  public String DKl;
  public boolean DKm;
  public int DKn;
  public String DKo;
  public int DKp;
  public LinkedList<rx> Drc;
  
  public bmv()
  {
    AppMethodBeat.i(91533);
    this.Drc = new LinkedList();
    AppMethodBeat.o(91533);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91534);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DKi != null) {
        paramVarArgs.d(1, this.DKi);
      }
      paramVarArgs.e(2, 8, this.Drc);
      paramVarArgs.bg(3, this.DKj);
      if (this.DKk != null)
      {
        paramVarArgs.kX(4, this.DKk.computeSize());
        this.DKk.writeFields(paramVarArgs);
      }
      if (this.DKl != null) {
        paramVarArgs.d(5, this.DKl);
      }
      paramVarArgs.bg(6, this.DKm);
      paramVarArgs.aR(7, this.DKn);
      if (this.DKo != null) {
        paramVarArgs.d(8, this.DKo);
      }
      paramVarArgs.aR(9, this.DKp);
      AppMethodBeat.o(91534);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DKi == null) {
        break label806;
      }
    }
    label806:
    for (paramInt = f.a.a.b.b.a.e(1, this.DKi) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.Drc) + (f.a.a.b.b.a.fY(3) + 1);
      paramInt = i;
      if (this.DKk != null) {
        paramInt = i + f.a.a.a.kW(4, this.DKk.computeSize());
      }
      i = paramInt;
      if (this.DKl != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.DKl);
      }
      i = i + (f.a.a.b.b.a.fY(6) + 1) + f.a.a.b.b.a.bA(7, this.DKn);
      paramInt = i;
      if (this.DKo != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.DKo);
      }
      i = f.a.a.b.b.a.bA(9, this.DKp);
      AppMethodBeat.o(91534);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Drc.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91534);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bmv localbmv = (bmv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91534);
          return -1;
        case 1: 
          localbmv.DKi = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91534);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((rx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbmv.Drc.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91534);
          return 0;
        case 3: 
          localbmv.DKj = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(91534);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbmv.DKk = ((hw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91534);
          return 0;
        case 5: 
          localbmv.DKl = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91534);
          return 0;
        case 6: 
          localbmv.DKm = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(91534);
          return 0;
        case 7: 
          localbmv.DKn = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91534);
          return 0;
        case 8: 
          localbmv.DKo = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91534);
          return 0;
        }
        localbmv.DKp = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(91534);
        return 0;
      }
      AppMethodBeat.o(91534);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmv
 * JD-Core Version:    0.7.0.1
 */