package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dwi
  extends com.tencent.mm.bx.a
{
  public int CHC;
  public dwf EKf;
  public int EKr;
  public boolean EKs;
  public String EKt;
  public int EKu;
  public int Egr;
  public int Egt;
  public String Md5;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153341);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EKf != null)
      {
        paramVarArgs.kX(1, this.EKf.computeSize());
        this.EKf.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.EKr);
      paramVarArgs.aR(3, this.Egr);
      paramVarArgs.aR(4, this.Egt);
      paramVarArgs.bg(5, this.EKs);
      paramVarArgs.aR(6, this.CHC);
      if (this.Md5 != null) {
        paramVarArgs.d(7, this.Md5);
      }
      if (this.EKt != null) {
        paramVarArgs.d(8, this.EKt);
      }
      paramVarArgs.aR(9, this.EKu);
      AppMethodBeat.o(153341);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EKf == null) {
        break label694;
      }
    }
    label694:
    for (paramInt = f.a.a.a.kW(1, this.EKf.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.EKr) + f.a.a.b.b.a.bA(3, this.Egr) + f.a.a.b.b.a.bA(4, this.Egt) + (f.a.a.b.b.a.fY(5) + 1) + f.a.a.b.b.a.bA(6, this.CHC);
      paramInt = i;
      if (this.Md5 != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Md5);
      }
      i = paramInt;
      if (this.EKt != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.EKt);
      }
      paramInt = f.a.a.b.b.a.bA(9, this.EKu);
      AppMethodBeat.o(153341);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(153341);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dwi localdwi = (dwi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153341);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dwf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dwf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdwi.EKf = ((dwf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153341);
          return 0;
        case 2: 
          localdwi.EKr = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(153341);
          return 0;
        case 3: 
          localdwi.Egr = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(153341);
          return 0;
        case 4: 
          localdwi.Egt = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(153341);
          return 0;
        case 5: 
          localdwi.EKs = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(153341);
          return 0;
        case 6: 
          localdwi.CHC = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(153341);
          return 0;
        case 7: 
          localdwi.Md5 = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(153341);
          return 0;
        case 8: 
          localdwi.EKt = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(153341);
          return 0;
        }
        localdwi.EKu = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(153341);
        return 0;
      }
      AppMethodBeat.o(153341);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwi
 * JD-Core Version:    0.7.0.1
 */