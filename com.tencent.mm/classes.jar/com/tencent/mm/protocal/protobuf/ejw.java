package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ejw
  extends com.tencent.mm.bw.a
{
  public int FYj;
  public int HHe;
  public int HHg;
  public ejt ImM;
  public int ImY;
  public boolean ImZ;
  public String Ina;
  public int Inb;
  public String Md5;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153341);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ImM != null)
      {
        paramVarArgs.lJ(1, this.ImM.computeSize());
        this.ImM.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.ImY);
      paramVarArgs.aS(3, this.HHe);
      paramVarArgs.aS(4, this.HHg);
      paramVarArgs.bC(5, this.ImZ);
      paramVarArgs.aS(6, this.FYj);
      if (this.Md5 != null) {
        paramVarArgs.d(7, this.Md5);
      }
      if (this.Ina != null) {
        paramVarArgs.d(8, this.Ina);
      }
      paramVarArgs.aS(9, this.Inb);
      AppMethodBeat.o(153341);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ImM == null) {
        break label690;
      }
    }
    label690:
    for (paramInt = f.a.a.a.lI(1, this.ImM.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.ImY) + f.a.a.b.b.a.bz(3, this.HHe) + f.a.a.b.b.a.bz(4, this.HHg) + f.a.a.b.b.a.amF(5) + f.a.a.b.b.a.bz(6, this.FYj);
      paramInt = i;
      if (this.Md5 != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Md5);
      }
      i = paramInt;
      if (this.Ina != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.Ina);
      }
      paramInt = f.a.a.b.b.a.bz(9, this.Inb);
      AppMethodBeat.o(153341);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(153341);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ejw localejw = (ejw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153341);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ejt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ejt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localejw.ImM = ((ejt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153341);
          return 0;
        case 2: 
          localejw.ImY = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(153341);
          return 0;
        case 3: 
          localejw.HHe = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(153341);
          return 0;
        case 4: 
          localejw.HHg = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(153341);
          return 0;
        case 5: 
          localejw.ImZ = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(153341);
          return 0;
        case 6: 
          localejw.FYj = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(153341);
          return 0;
        case 7: 
          localejw.Md5 = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153341);
          return 0;
        case 8: 
          localejw.Ina = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153341);
          return 0;
        }
        localejw.Inb = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(153341);
        return 0;
      }
      AppMethodBeat.o(153341);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ejw
 * JD-Core Version:    0.7.0.1
 */