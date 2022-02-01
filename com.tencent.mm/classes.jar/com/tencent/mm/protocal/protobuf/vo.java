package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class vo
  extends com.tencent.mm.bx.a
{
  public LinkedList<uq> Zaf;
  public fxy Zbl;
  public int Zbm;
  public int Zbn;
  public String mAD;
  
  public vo()
  {
    AppMethodBeat.i(258830);
    this.Zaf = new LinkedList();
    AppMethodBeat.o(258830);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258835);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Zbl == null)
      {
        paramVarArgs = new b("Not all required fields were included: matrix");
        AppMethodBeat.o(258835);
        throw paramVarArgs;
      }
      paramVarArgs.e(1, 8, this.Zaf);
      if (this.Zbl != null)
      {
        paramVarArgs.qD(2, this.Zbl.computeSize());
        this.Zbl.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(3, this.Zbm);
      paramVarArgs.bS(4, this.Zbn);
      if (this.mAD != null) {
        paramVarArgs.g(5, this.mAD);
      }
      AppMethodBeat.o(258835);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.a.c(1, 8, this.Zaf) + 0;
      paramInt = i;
      if (this.Zbl != null) {
        paramInt = i + i.a.a.a.qC(2, this.Zbl.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(3, this.Zbm) + i.a.a.b.b.a.cJ(4, this.Zbn);
      paramInt = i;
      if (this.mAD != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.mAD);
      }
      AppMethodBeat.o(258835);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Zaf.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      if (this.Zbl == null)
      {
        paramVarArgs = new b("Not all required fields were included: matrix");
        AppMethodBeat.o(258835);
        throw paramVarArgs;
      }
      AppMethodBeat.o(258835);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      vo localvo = (vo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(258835);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new uq();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((uq)localObject2).parseFrom((byte[])localObject1);
          }
          localvo.Zaf.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258835);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fxy();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fxy)localObject2).parseFrom((byte[])localObject1);
          }
          localvo.Zbl = ((fxy)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258835);
        return 0;
      case 3: 
        localvo.Zbm = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(258835);
        return 0;
      case 4: 
        localvo.Zbn = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(258835);
        return 0;
      }
      localvo.mAD = ((i.a.a.a.a)localObject1).ajGk.readString();
      AppMethodBeat.o(258835);
      return 0;
    }
    AppMethodBeat.o(258835);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vo
 * JD-Core Version:    0.7.0.1
 */