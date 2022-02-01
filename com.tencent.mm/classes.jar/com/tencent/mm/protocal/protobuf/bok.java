package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bok
  extends cvp
{
  public LinkedList<bol> GIZ;
  public ckg GJa;
  public cwb GJb;
  public boolean GJc;
  public iu GJd;
  public int ozR;
  public String ozS;
  
  public bok()
  {
    AppMethodBeat.i(72502);
    this.GIZ = new LinkedList();
    AppMethodBeat.o(72502);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72503);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72503);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.ozR);
      if (this.ozS != null) {
        paramVarArgs.d(3, this.ozS);
      }
      paramVarArgs.e(4, 8, this.GIZ);
      if (this.GJa != null)
      {
        paramVarArgs.lC(5, this.GJa.computeSize());
        this.GJa.writeFields(paramVarArgs);
      }
      if (this.GJb != null)
      {
        paramVarArgs.lC(6, this.GJb.computeSize());
        this.GJb.writeFields(paramVarArgs);
      }
      paramVarArgs.bt(7, this.GJc);
      if (this.GJd != null)
      {
        paramVarArgs.lC(8, this.GJd.computeSize());
        this.GJd.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72503);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1110;
      }
    }
    label1110:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.ozR);
      paramInt = i;
      if (this.ozS != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.ozS);
      }
      i = paramInt + f.a.a.a.c(4, 8, this.GIZ);
      paramInt = i;
      if (this.GJa != null) {
        paramInt = i + f.a.a.a.lB(5, this.GJa.computeSize());
      }
      i = paramInt;
      if (this.GJb != null) {
        i = paramInt + f.a.a.a.lB(6, this.GJb.computeSize());
      }
      i += f.a.a.b.b.a.alV(7);
      paramInt = i;
      if (this.GJd != null) {
        paramInt = i + f.a.a.a.lB(8, this.GJd.computeSize());
      }
      AppMethodBeat.o(72503);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GIZ.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72503);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72503);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bok localbok = (bok)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72503);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbok.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72503);
          return 0;
        case 2: 
          localbok.ozR = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72503);
          return 0;
        case 3: 
          localbok.ozS = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72503);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bol();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bol)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbok.GIZ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72503);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ckg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ckg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbok.GJa = ((ckg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72503);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbok.GJb = ((cwb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72503);
          return 0;
        case 7: 
          localbok.GJc = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(72503);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new iu();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((iu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbok.GJd = ((iu)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72503);
        return 0;
      }
      AppMethodBeat.o(72503);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bok
 * JD-Core Version:    0.7.0.1
 */