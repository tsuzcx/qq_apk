package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dxo
  extends cvw
{
  public long Gsg;
  public LinkedList<dxw> IcN;
  public dxw IcO;
  public LinkedList<dxq> IcP;
  public String Icy;
  public String Icz;
  
  public dxo()
  {
    AppMethodBeat.i(190863);
    this.IcP = new LinkedList();
    this.IcN = new LinkedList();
    AppMethodBeat.o(190863);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(190864);
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
      if (this.IcO != null)
      {
        paramVarArgs.lJ(3, this.IcO.computeSize());
        this.IcO.writeFields(paramVarArgs);
      }
      paramVarArgs.aZ(4, this.Gsg);
      if (this.Icz != null) {
        paramVarArgs.d(5, this.Icz);
      }
      paramVarArgs.e(6, 8, this.IcP);
      paramVarArgs.e(7, 8, this.IcN);
      AppMethodBeat.o(190864);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label914;
      }
    }
    label914:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Icy != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Icy);
      }
      i = paramInt;
      if (this.IcO != null) {
        i = paramInt + f.a.a.a.lI(3, this.IcO.computeSize());
      }
      i += f.a.a.b.b.a.p(4, this.Gsg);
      paramInt = i;
      if (this.Icz != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Icz);
      }
      i = f.a.a.a.c(6, 8, this.IcP);
      int j = f.a.a.a.c(7, 8, this.IcN);
      AppMethodBeat.o(190864);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.IcP.clear();
        this.IcN.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(190864);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dxo localdxo = (dxo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(190864);
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
            localdxo.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(190864);
          return 0;
        case 2: 
          localdxo.Icy = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(190864);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dxw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dxw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdxo.IcO = ((dxw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(190864);
          return 0;
        case 4: 
          localdxo.Gsg = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(190864);
          return 0;
        case 5: 
          localdxo.Icz = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(190864);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dxq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dxq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdxo.IcP.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(190864);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dxw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dxw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdxo.IcN.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(190864);
        return 0;
      }
      AppMethodBeat.o(190864);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxo
 * JD-Core Version:    0.7.0.1
 */