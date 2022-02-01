package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class csj
  extends com.tencent.mm.bx.a
{
  public String HkF;
  public LinkedList<djf> HkG;
  public String HkH;
  public String HkI;
  public String HkJ;
  public csh HkK;
  public String description;
  public String hzA;
  public String hzB;
  public String hzC;
  public int ozA;
  public String title;
  
  public csj()
  {
    AppMethodBeat.i(168759);
    this.HkG = new LinkedList();
    AppMethodBeat.o(168759);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168760);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.hzB != null) {
        paramVarArgs.d(2, this.hzB);
      }
      if (this.hzC != null) {
        paramVarArgs.d(3, this.hzC);
      }
      if (this.description != null) {
        paramVarArgs.d(4, this.description);
      }
      if (this.HkF != null) {
        paramVarArgs.d(9, this.HkF);
      }
      paramVarArgs.e(10, 8, this.HkG);
      paramVarArgs.aS(11, this.ozA);
      if (this.HkH != null) {
        paramVarArgs.d(12, this.HkH);
      }
      if (this.HkI != null) {
        paramVarArgs.d(13, this.HkI);
      }
      if (this.HkJ != null) {
        paramVarArgs.d(14, this.HkJ);
      }
      if (this.hzA != null) {
        paramVarArgs.d(15, this.hzA);
      }
      if (this.HkK != null)
      {
        paramVarArgs.lC(16, this.HkK.computeSize());
        this.HkK.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(168760);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label1066;
      }
    }
    label1066:
    for (int i = f.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hzB != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.hzB);
      }
      i = paramInt;
      if (this.hzC != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.hzC);
      }
      paramInt = i;
      if (this.description != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.description);
      }
      i = paramInt;
      if (this.HkF != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.HkF);
      }
      i = i + f.a.a.a.c(10, 8, this.HkG) + f.a.a.b.b.a.bz(11, this.ozA);
      paramInt = i;
      if (this.HkH != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.HkH);
      }
      i = paramInt;
      if (this.HkI != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.HkI);
      }
      paramInt = i;
      if (this.HkJ != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.HkJ);
      }
      i = paramInt;
      if (this.hzA != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.hzA);
      }
      paramInt = i;
      if (this.HkK != null) {
        paramInt = i + f.a.a.a.lB(16, this.HkK.computeSize());
      }
      AppMethodBeat.o(168760);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HkG.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(168760);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        csj localcsj = (csj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 5: 
        case 6: 
        case 7: 
        case 8: 
        default: 
          AppMethodBeat.o(168760);
          return -1;
        case 1: 
          localcsj.title = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(168760);
          return 0;
        case 2: 
          localcsj.hzB = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(168760);
          return 0;
        case 3: 
          localcsj.hzC = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(168760);
          return 0;
        case 4: 
          localcsj.description = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(168760);
          return 0;
        case 9: 
          localcsj.HkF = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(168760);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new djf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((djf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcsj.HkG.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168760);
          return 0;
        case 11: 
          localcsj.ozA = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(168760);
          return 0;
        case 12: 
          localcsj.HkH = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(168760);
          return 0;
        case 13: 
          localcsj.HkI = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(168760);
          return 0;
        case 14: 
          localcsj.HkJ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(168760);
          return 0;
        case 15: 
          localcsj.hzA = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(168760);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new csh();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((csh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcsj.HkK = ((csh)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(168760);
        return 0;
      }
      AppMethodBeat.o(168760);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csj
 * JD-Core Version:    0.7.0.1
 */