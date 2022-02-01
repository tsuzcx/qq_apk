package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class yp
  extends com.tencent.mm.bx.a
{
  public String CDW;
  public LinkedList<dbp> CRg;
  public dbp Cvo;
  public LinkedList<dbp> DaP;
  public String DaQ;
  public int state;
  
  public yp()
  {
    AppMethodBeat.i(91427);
    this.CRg = new LinkedList();
    this.DaP = new LinkedList();
    AppMethodBeat.o(91427);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91428);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.state);
      if (this.Cvo != null)
      {
        paramVarArgs.kX(2, this.Cvo.computeSize());
        this.Cvo.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.CRg);
      paramVarArgs.e(4, 8, this.DaP);
      if (this.DaQ != null) {
        paramVarArgs.d(5, this.DaQ);
      }
      if (this.CDW != null) {
        paramVarArgs.d(6, this.CDW);
      }
      AppMethodBeat.o(91428);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.state) + 0;
      paramInt = i;
      if (this.Cvo != null) {
        paramInt = i + f.a.a.a.kW(2, this.Cvo.computeSize());
      }
      i = paramInt + f.a.a.a.c(3, 8, this.CRg) + f.a.a.a.c(4, 8, this.DaP);
      paramInt = i;
      if (this.DaQ != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.DaQ);
      }
      i = paramInt;
      if (this.CDW != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.CDW);
      }
      AppMethodBeat.o(91428);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.CRg.clear();
      this.DaP.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(91428);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      yp localyp = (yp)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91428);
        return -1;
      case 1: 
        localyp.state = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(91428);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dbp();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dbp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localyp.Cvo = ((dbp)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91428);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dbp();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dbp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localyp.CRg.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91428);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dbp();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dbp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localyp.DaP.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91428);
        return 0;
      case 5: 
        localyp.DaQ = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91428);
        return 0;
      }
      localyp.CDW = ((f.a.a.a.a)localObject1).KhF.readString();
      AppMethodBeat.o(91428);
      return 0;
    }
    AppMethodBeat.o(91428);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yp
 * JD-Core Version:    0.7.0.1
 */