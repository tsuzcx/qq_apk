package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dxs
  extends cvw
{
  public dxw IcO;
  public LinkedList<dxr> IcS;
  public String Icy;
  public String Icz;
  
  public dxs()
  {
    AppMethodBeat.i(190868);
    this.IcS = new LinkedList();
    AppMethodBeat.o(190868);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(190869);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Icy != null) {
        paramVarArgs.d(2, this.Icy);
      }
      if (this.Icz != null) {
        paramVarArgs.d(3, this.Icz);
      }
      if (this.IcO != null)
      {
        paramVarArgs.lJ(4, this.IcO.computeSize());
        this.IcO.writeFields(paramVarArgs);
      }
      paramVarArgs.e(5, 8, this.IcS);
      AppMethodBeat.o(190869);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label726;
      }
    }
    label726:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Icy != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Icy);
      }
      i = paramInt;
      if (this.Icz != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Icz);
      }
      paramInt = i;
      if (this.IcO != null) {
        paramInt = i + f.a.a.a.lI(4, this.IcO.computeSize());
      }
      i = f.a.a.a.c(5, 8, this.IcS);
      AppMethodBeat.o(190869);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.IcS.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(190869);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dxs localdxs = (dxs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(190869);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdxs.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(190869);
          return 0;
        case 2: 
          localdxs.Icy = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(190869);
          return 0;
        case 3: 
          localdxs.Icz = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(190869);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dxw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dxw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdxs.IcO = ((dxw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(190869);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dxr();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dxr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdxs.IcS.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(190869);
        return 0;
      }
      AppMethodBeat.o(190869);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxs
 * JD-Core Version:    0.7.0.1
 */