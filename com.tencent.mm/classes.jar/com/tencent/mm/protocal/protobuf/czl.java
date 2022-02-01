package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class czl
  extends ckq
{
  public LinkedList<Integer> Ejc;
  public String Ejd;
  public String Eje;
  public String dgo;
  public String dlB;
  
  public czl()
  {
    AppMethodBeat.i(123656);
    this.Ejc = new LinkedList();
    AppMethodBeat.o(123656);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123657);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.dlB != null) {
        paramVarArgs.d(2, this.dlB);
      }
      paramVarArgs.e(3, 2, this.Ejc);
      if (this.Ejd != null) {
        paramVarArgs.d(4, this.Ejd);
      }
      if (this.dgo != null) {
        paramVarArgs.d(5, this.dgo);
      }
      if (this.Eje != null) {
        paramVarArgs.d(6, this.Eje);
      }
      AppMethodBeat.o(123657);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label613;
      }
    }
    label613:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.dlB != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.dlB);
      }
      i += f.a.a.a.c(3, 2, this.Ejc);
      paramInt = i;
      if (this.Ejd != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Ejd);
      }
      i = paramInt;
      if (this.dgo != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.dgo);
      }
      paramInt = i;
      if (this.Eje != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Eje);
      }
      AppMethodBeat.o(123657);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Ejc.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(123657);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        czl localczl = (czl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123657);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localczl.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123657);
          return 0;
        case 2: 
          localczl.dlB = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123657);
          return 0;
        case 3: 
          localczl.Ejc.add(Integer.valueOf(((f.a.a.a.a)localObject1).KhF.xS()));
          AppMethodBeat.o(123657);
          return 0;
        case 4: 
          localczl.Ejd = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123657);
          return 0;
        case 5: 
          localczl.dgo = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123657);
          return 0;
        }
        localczl.Eje = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(123657);
        return 0;
      }
      AppMethodBeat.o(123657);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czl
 * JD-Core Version:    0.7.0.1
 */