package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bbo
  extends cvw
{
  public String GRA;
  public int GRw;
  public aez GRx;
  public LinkedList<ahv> GRy;
  public int GRz;
  public int Scene;
  
  public bbo()
  {
    AppMethodBeat.i(196261);
    this.GRy = new LinkedList();
    AppMethodBeat.o(196261);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(196262);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GRx == null)
      {
        paramVarArgs = new b("Not all required fields were included: DeviceType");
        AppMethodBeat.o(196262);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.GRw);
      paramVarArgs.aS(3, this.Scene);
      if (this.GRx != null)
      {
        paramVarArgs.lJ(4, this.GRx.computeSize());
        this.GRx.writeFields(paramVarArgs);
      }
      paramVarArgs.e(5, 8, this.GRy);
      paramVarArgs.aS(6, this.GRz);
      if (this.GRA != null) {
        paramVarArgs.d(7, this.GRA);
      }
      AppMethodBeat.o(196262);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label846;
      }
    }
    label846:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.GRw) + f.a.a.b.b.a.bz(3, this.Scene);
      paramInt = i;
      if (this.GRx != null) {
        paramInt = i + f.a.a.a.lI(4, this.GRx.computeSize());
      }
      i = paramInt + f.a.a.a.c(5, 8, this.GRy) + f.a.a.b.b.a.bz(6, this.GRz);
      paramInt = i;
      if (this.GRA != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.GRA);
      }
      AppMethodBeat.o(196262);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GRy.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.GRx == null)
        {
          paramVarArgs = new b("Not all required fields were included: DeviceType");
          AppMethodBeat.o(196262);
          throw paramVarArgs;
        }
        AppMethodBeat.o(196262);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bbo localbbo = (bbo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(196262);
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
            localbbo.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(196262);
          return 0;
        case 2: 
          localbbo.GRw = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(196262);
          return 0;
        case 3: 
          localbbo.Scene = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(196262);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aez();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aez)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbbo.GRx = ((aez)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(196262);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ahv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ahv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbbo.GRy.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(196262);
          return 0;
        case 6: 
          localbbo.GRz = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(196262);
          return 0;
        }
        localbbo.GRA = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(196262);
        return 0;
      }
      AppMethodBeat.o(196262);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbo
 * JD-Core Version:    0.7.0.1
 */