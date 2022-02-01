package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class edk
  extends cvw
{
  public int DTy;
  public double Iit;
  public double Iiu;
  public String Iiv;
  public LinkedList<dva> Iiw;
  public int scene;
  public String sessionId;
  
  public edk()
  {
    AppMethodBeat.i(121112);
    this.Iiw = new LinkedList();
    AppMethodBeat.o(121112);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(121113);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, this.Iit);
      paramVarArgs.e(3, this.Iiu);
      if (this.Iiv != null) {
        paramVarArgs.d(4, this.Iiv);
      }
      paramVarArgs.aS(5, this.DTy);
      if (this.sessionId != null) {
        paramVarArgs.d(6, this.sessionId);
      }
      paramVarArgs.aS(7, this.scene);
      paramVarArgs.e(8, 8, this.Iiw);
      AppMethodBeat.o(121113);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label752;
      }
    }
    label752:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.amD(2) + f.a.a.b.b.a.amD(3);
      paramInt = i;
      if (this.Iiv != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Iiv);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.DTy);
      paramInt = i;
      if (this.sessionId != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.sessionId);
      }
      i = f.a.a.b.b.a.bz(7, this.scene);
      int j = f.a.a.a.c(8, 8, this.Iiw);
      AppMethodBeat.o(121113);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Iiw.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(121113);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        edk localedk = (edk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(121113);
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
            localedk.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(121113);
          return 0;
        case 2: 
          localedk.Iit = Double.longBitsToDouble(((f.a.a.a.a)localObject1).OmT.gwc());
          AppMethodBeat.o(121113);
          return 0;
        case 3: 
          localedk.Iiu = Double.longBitsToDouble(((f.a.a.a.a)localObject1).OmT.gwc());
          AppMethodBeat.o(121113);
          return 0;
        case 4: 
          localedk.Iiv = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(121113);
          return 0;
        case 5: 
          localedk.DTy = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(121113);
          return 0;
        case 6: 
          localedk.sessionId = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(121113);
          return 0;
        case 7: 
          localedk.scene = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(121113);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dva();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dva)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localedk.Iiw.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(121113);
        return 0;
      }
      AppMethodBeat.o(121113);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.edk
 * JD-Core Version:    0.7.0.1
 */