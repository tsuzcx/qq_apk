package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dml
  extends com.tencent.mm.bw.a
{
  public String Gct;
  public LinkedList<dmm> Gcu;
  public long Gcv;
  public String Gys;
  public String Gyt;
  public dmn HTL;
  public dmp HTM;
  
  public dml()
  {
    AppMethodBeat.i(124556);
    this.Gcu = new LinkedList();
    AppMethodBeat.o(124556);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124557);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gys != null) {
        paramVarArgs.d(1, this.Gys);
      }
      if (this.HTL != null)
      {
        paramVarArgs.lJ(2, this.HTL.computeSize());
        this.HTL.writeFields(paramVarArgs);
      }
      if (this.Gct != null) {
        paramVarArgs.d(3, this.Gct);
      }
      paramVarArgs.e(4, 8, this.Gcu);
      if (this.Gyt != null) {
        paramVarArgs.d(5, this.Gyt);
      }
      paramVarArgs.aZ(6, this.Gcv);
      if (this.HTM != null)
      {
        paramVarArgs.lJ(7, this.HTM.computeSize());
        this.HTM.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(124557);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Gys == null) {
        break label834;
      }
    }
    label834:
    for (int i = f.a.a.b.b.a.e(1, this.Gys) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HTL != null) {
        paramInt = i + f.a.a.a.lI(2, this.HTL.computeSize());
      }
      i = paramInt;
      if (this.Gct != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Gct);
      }
      i += f.a.a.a.c(4, 8, this.Gcu);
      paramInt = i;
      if (this.Gyt != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Gyt);
      }
      i = paramInt + f.a.a.b.b.a.p(6, this.Gcv);
      paramInt = i;
      if (this.HTM != null) {
        paramInt = i + f.a.a.a.lI(7, this.HTM.computeSize());
      }
      AppMethodBeat.o(124557);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Gcu.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(124557);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dml localdml = (dml)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124557);
          return -1;
        case 1: 
          localdml.Gys = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(124557);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dmn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dmn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdml.HTL = ((dmn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124557);
          return 0;
        case 3: 
          localdml.Gct = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(124557);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dmm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dmm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdml.Gcu.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124557);
          return 0;
        case 5: 
          localdml.Gyt = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(124557);
          return 0;
        case 6: 
          localdml.Gcv = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(124557);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dmp();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dmp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdml.HTM = ((dmp)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124557);
        return 0;
      }
      AppMethodBeat.o(124557);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dml
 * JD-Core Version:    0.7.0.1
 */