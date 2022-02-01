package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fpp
  extends com.tencent.mm.cd.a
{
  public fpo UNA;
  public fpv UNB;
  public fpr UNu;
  public fpq UNv;
  public fps UNw;
  public fpu UNx;
  public fpt UNy;
  public fpw UNz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153340);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UNu != null)
      {
        paramVarArgs.oE(1, this.UNu.computeSize());
        this.UNu.writeFields(paramVarArgs);
      }
      if (this.UNv != null)
      {
        paramVarArgs.oE(2, this.UNv.computeSize());
        this.UNv.writeFields(paramVarArgs);
      }
      if (this.UNw != null)
      {
        paramVarArgs.oE(3, this.UNw.computeSize());
        this.UNw.writeFields(paramVarArgs);
      }
      if (this.UNx != null)
      {
        paramVarArgs.oE(4, this.UNx.computeSize());
        this.UNx.writeFields(paramVarArgs);
      }
      if (this.UNy != null)
      {
        paramVarArgs.oE(5, this.UNy.computeSize());
        this.UNy.writeFields(paramVarArgs);
      }
      if (this.UNz != null)
      {
        paramVarArgs.oE(6, this.UNz.computeSize());
        this.UNz.writeFields(paramVarArgs);
      }
      if (this.UNA != null)
      {
        paramVarArgs.oE(7, this.UNA.computeSize());
        this.UNA.writeFields(paramVarArgs);
      }
      if (this.UNB != null)
      {
        paramVarArgs.oE(8, this.UNB.computeSize());
        this.UNB.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(153340);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UNu == null) {
        break label1218;
      }
    }
    label1218:
    for (int i = g.a.a.a.oD(1, this.UNu.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UNv != null) {
        paramInt = i + g.a.a.a.oD(2, this.UNv.computeSize());
      }
      i = paramInt;
      if (this.UNw != null) {
        i = paramInt + g.a.a.a.oD(3, this.UNw.computeSize());
      }
      paramInt = i;
      if (this.UNx != null) {
        paramInt = i + g.a.a.a.oD(4, this.UNx.computeSize());
      }
      i = paramInt;
      if (this.UNy != null) {
        i = paramInt + g.a.a.a.oD(5, this.UNy.computeSize());
      }
      paramInt = i;
      if (this.UNz != null) {
        paramInt = i + g.a.a.a.oD(6, this.UNz.computeSize());
      }
      i = paramInt;
      if (this.UNA != null) {
        i = paramInt + g.a.a.a.oD(7, this.UNA.computeSize());
      }
      paramInt = i;
      if (this.UNB != null) {
        paramInt = i + g.a.a.a.oD(8, this.UNB.computeSize());
      }
      AppMethodBeat.o(153340);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(153340);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        fpp localfpp = (fpp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153340);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fpr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fpr)localObject2).parseFrom((byte[])localObject1);
            }
            localfpp.UNu = ((fpr)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153340);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fpq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fpq)localObject2).parseFrom((byte[])localObject1);
            }
            localfpp.UNv = ((fpq)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153340);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fps();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fps)localObject2).parseFrom((byte[])localObject1);
            }
            localfpp.UNw = ((fps)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153340);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fpu();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fpu)localObject2).parseFrom((byte[])localObject1);
            }
            localfpp.UNx = ((fpu)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153340);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fpt();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fpt)localObject2).parseFrom((byte[])localObject1);
            }
            localfpp.UNy = ((fpt)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153340);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fpw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fpw)localObject2).parseFrom((byte[])localObject1);
            }
            localfpp.UNz = ((fpw)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153340);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fpo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fpo)localObject2).parseFrom((byte[])localObject1);
            }
            localfpp.UNA = ((fpo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153340);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fpv();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fpv)localObject2).parseFrom((byte[])localObject1);
          }
          localfpp.UNB = ((fpv)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(153340);
        return 0;
      }
      AppMethodBeat.o(153340);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fpp
 * JD-Core Version:    0.7.0.1
 */