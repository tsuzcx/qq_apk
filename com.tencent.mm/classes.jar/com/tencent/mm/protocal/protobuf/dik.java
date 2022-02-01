package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dik
  extends com.tencent.mm.bx.a
{
  public int DPe;
  public LinkedList<dil> EyD;
  public String EyE;
  public int EyF;
  public int apptype;
  public String dlB;
  public String gIw;
  public String nvv;
  
  public dik()
  {
    AppMethodBeat.i(74672);
    this.EyD = new LinkedList();
    AppMethodBeat.o(74672);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(74673);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dlB != null) {
        paramVarArgs.d(1, this.dlB);
      }
      if (this.gIw != null) {
        paramVarArgs.d(2, this.gIw);
      }
      paramVarArgs.aR(3, this.apptype);
      paramVarArgs.e(4, 8, this.EyD);
      paramVarArgs.aR(5, this.DPe);
      if (this.EyE != null) {
        paramVarArgs.d(6, this.EyE);
      }
      if (this.nvv != null) {
        paramVarArgs.d(7, this.nvv);
      }
      paramVarArgs.aR(8, this.EyF);
      AppMethodBeat.o(74673);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dlB == null) {
        break label670;
      }
    }
    label670:
    for (paramInt = f.a.a.b.b.a.e(1, this.dlB) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.gIw != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.gIw);
      }
      i = i + f.a.a.b.b.a.bA(3, this.apptype) + f.a.a.a.c(4, 8, this.EyD) + f.a.a.b.b.a.bA(5, this.DPe);
      paramInt = i;
      if (this.EyE != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.EyE);
      }
      i = paramInt;
      if (this.nvv != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.nvv);
      }
      paramInt = f.a.a.b.b.a.bA(8, this.EyF);
      AppMethodBeat.o(74673);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EyD.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(74673);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dik localdik = (dik)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(74673);
          return -1;
        case 1: 
          localdik.dlB = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(74673);
          return 0;
        case 2: 
          localdik.gIw = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(74673);
          return 0;
        case 3: 
          localdik.apptype = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(74673);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dil();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dil)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdik.EyD.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(74673);
          return 0;
        case 5: 
          localdik.DPe = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(74673);
          return 0;
        case 6: 
          localdik.EyE = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(74673);
          return 0;
        case 7: 
          localdik.nvv = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(74673);
          return 0;
        }
        localdik.EyF = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(74673);
        return 0;
      }
      AppMethodBeat.o(74673);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dik
 * JD-Core Version:    0.7.0.1
 */