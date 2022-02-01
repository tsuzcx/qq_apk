package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class anc
  extends com.tencent.mm.bx.a
{
  public LinkedList<cqp> Doe;
  public cqp Dof;
  public LinkedList<anb> Dog;
  public boolean Doh;
  public String Doi;
  public long Doj;
  public String dpw;
  public boolean qHI;
  
  public anc()
  {
    AppMethodBeat.i(122501);
    this.Doe = new LinkedList();
    this.Dog = new LinkedList();
    this.Doh = false;
    this.qHI = false;
    AppMethodBeat.o(122501);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122502);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dpw != null) {
        paramVarArgs.d(1, this.dpw);
      }
      paramVarArgs.e(2, 8, this.Doe);
      if (this.Dof != null)
      {
        paramVarArgs.kX(3, this.Dof.computeSize());
        this.Dof.writeFields(paramVarArgs);
      }
      paramVarArgs.e(4, 8, this.Dog);
      paramVarArgs.bg(5, this.Doh);
      paramVarArgs.bg(6, this.qHI);
      if (this.Doi != null) {
        paramVarArgs.d(7, this.Doi);
      }
      paramVarArgs.aG(8, this.Doj);
      AppMethodBeat.o(122502);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dpw == null) {
        break label842;
      }
    }
    label842:
    for (paramInt = f.a.a.b.b.a.e(1, this.dpw) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.Doe);
      paramInt = i;
      if (this.Dof != null) {
        paramInt = i + f.a.a.a.kW(3, this.Dof.computeSize());
      }
      i = paramInt + f.a.a.a.c(4, 8, this.Dog) + (f.a.a.b.b.a.fY(5) + 1) + (f.a.a.b.b.a.fY(6) + 1);
      paramInt = i;
      if (this.Doi != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Doi);
      }
      i = f.a.a.b.b.a.q(8, this.Doj);
      AppMethodBeat.o(122502);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Doe.clear();
        this.Dog.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(122502);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        anc localanc = (anc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122502);
          return -1;
        case 1: 
          localanc.dpw = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(122502);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cqp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cqp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localanc.Doe.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122502);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cqp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cqp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localanc.Dof = ((cqp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122502);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new anb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((anb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localanc.Dog.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122502);
          return 0;
        case 5: 
          localanc.Doh = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(122502);
          return 0;
        case 6: 
          localanc.qHI = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(122502);
          return 0;
        case 7: 
          localanc.Doi = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(122502);
          return 0;
        }
        localanc.Doj = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(122502);
        return 0;
      }
      AppMethodBeat.o(122502);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.anc
 * JD-Core Version:    0.7.0.1
 */