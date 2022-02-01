package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class fdu
  extends esc
{
  public int IcW;
  public LinkedList<SnsObject> YMT;
  public int aaWr;
  public String abDu;
  public int abDy;
  public ffb abDz;
  public String crB;
  
  public fdu()
  {
    AppMethodBeat.i(125776);
    this.YMT = new LinkedList();
    AppMethodBeat.o(125776);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125777);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(125777);
        throw paramVarArgs;
      }
      if (this.abDz == null)
      {
        paramVarArgs = new b("Not all required fields were included: ServerConfig");
        AppMethodBeat.o(125777);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.abDu != null) {
        paramVarArgs.g(2, this.abDu);
      }
      paramVarArgs.bS(3, this.aaWr);
      paramVarArgs.e(4, 8, this.YMT);
      paramVarArgs.bS(5, this.abDy);
      if (this.crB != null) {
        paramVarArgs.g(6, this.crB);
      }
      paramVarArgs.bS(7, this.IcW);
      if (this.abDz != null)
      {
        paramVarArgs.qD(8, this.abDz.computeSize());
        this.abDz.writeFields(paramVarArgs);
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
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.abDu != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.abDu);
      }
      i = i + i.a.a.b.b.a.cJ(3, this.aaWr) + i.a.a.a.c(4, 8, this.YMT) + i.a.a.b.b.a.cJ(5, this.abDy);
      paramInt = i;
      if (this.crB != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.crB);
      }
      i = paramInt + i.a.a.b.b.a.cJ(7, this.IcW);
      paramInt = i;
      if (this.abDz != null) {
        paramInt = i + i.a.a.a.qC(8, this.abDz.computeSize());
      }
      AppMethodBeat.o(125777);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YMT.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(125777);
          throw paramVarArgs;
        }
        if (this.abDz == null)
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
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fdu localfdu = (fdu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125777);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localfdu.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125777);
          return 0;
        case 2: 
          localfdu.abDu = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(125777);
          return 0;
        case 3: 
          localfdu.aaWr = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125777);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new SnsObject();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((SnsObject)localObject2).parseFrom((byte[])localObject1);
            }
            localfdu.YMT.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125777);
          return 0;
        case 5: 
          localfdu.abDy = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125777);
          return 0;
        case 6: 
          localfdu.crB = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(125777);
          return 0;
        case 7: 
          localfdu.IcW = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125777);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ffb();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ffb)localObject2).parseFrom((byte[])localObject1);
          }
          localfdu.abDz = ((ffb)localObject2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fdu
 * JD-Core Version:    0.7.0.1
 */