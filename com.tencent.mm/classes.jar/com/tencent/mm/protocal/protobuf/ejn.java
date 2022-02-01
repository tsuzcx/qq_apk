package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ejn
  extends dyy
{
  public int CqN;
  public String RIC;
  public LinkedList<SnsObject> RPF;
  public int TGK;
  public String UlA;
  public int UlE;
  public ekt UlF;
  
  public ejn()
  {
    AppMethodBeat.i(125776);
    this.RPF = new LinkedList();
    AppMethodBeat.o(125776);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125777);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(125777);
        throw paramVarArgs;
      }
      if (this.UlF == null)
      {
        paramVarArgs = new b("Not all required fields were included: ServerConfig");
        AppMethodBeat.o(125777);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.UlA != null) {
        paramVarArgs.f(2, this.UlA);
      }
      paramVarArgs.aY(3, this.TGK);
      paramVarArgs.e(4, 8, this.RPF);
      paramVarArgs.aY(5, this.UlE);
      if (this.RIC != null) {
        paramVarArgs.f(6, this.RIC);
      }
      paramVarArgs.aY(7, this.CqN);
      if (this.UlF != null)
      {
        paramVarArgs.oE(8, this.UlF.computeSize());
        this.UlF.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125777);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label888;
      }
    }
    label888:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.UlA != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.UlA);
      }
      i = i + g.a.a.b.b.a.bM(3, this.TGK) + g.a.a.a.c(4, 8, this.RPF) + g.a.a.b.b.a.bM(5, this.UlE);
      paramInt = i;
      if (this.RIC != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.RIC);
      }
      i = paramInt + g.a.a.b.b.a.bM(7, this.CqN);
      paramInt = i;
      if (this.UlF != null) {
        paramInt = i + g.a.a.a.oD(8, this.UlF.computeSize());
      }
      AppMethodBeat.o(125777);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.RPF.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(125777);
          throw paramVarArgs;
        }
        if (this.UlF == null)
        {
          paramVarArgs = new b("Not all required fields were included: ServerConfig");
          AppMethodBeat.o(125777);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125777);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ejn localejn = (ejn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125777);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localejn.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125777);
          return 0;
        case 2: 
          localejn.UlA = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(125777);
          return 0;
        case 3: 
          localejn.TGK = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125777);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new SnsObject();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((SnsObject)localObject2).parseFrom((byte[])localObject1);
            }
            localejn.RPF.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125777);
          return 0;
        case 5: 
          localejn.UlE = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125777);
          return 0;
        case 6: 
          localejn.RIC = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(125777);
          return 0;
        case 7: 
          localejn.CqN = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125777);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ekt();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ekt)localObject2).parseFrom((byte[])localObject1);
          }
          localejn.UlF = ((ekt)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125777);
        return 0;
      }
      AppMethodBeat.o(125777);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ejn
 * JD-Core Version:    0.7.0.1
 */