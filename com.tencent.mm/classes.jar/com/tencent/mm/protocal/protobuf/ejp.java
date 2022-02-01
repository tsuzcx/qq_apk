package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ejp
  extends esc
{
  public String VBL;
  public eff YNL;
  public String aboh;
  public LinkedList<jp> aboi;
  public String wuA;
  public int wuz;
  
  public ejp()
  {
    AppMethodBeat.i(72553);
    this.aboi = new LinkedList();
    AppMethodBeat.o(72553);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72554);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72554);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.wuz);
      if (this.wuA != null) {
        paramVarArgs.g(3, this.wuA);
      }
      if (this.aboh != null) {
        paramVarArgs.g(4, this.aboh);
      }
      paramVarArgs.e(5, 8, this.aboi);
      if (this.YNL != null)
      {
        paramVarArgs.qD(6, this.YNL.computeSize());
        this.YNL.writeFields(paramVarArgs);
      }
      if (this.VBL != null) {
        paramVarArgs.g(7, this.VBL);
      }
      AppMethodBeat.o(72554);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label812;
      }
    }
    label812:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.wuz);
      paramInt = i;
      if (this.wuA != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wuA);
      }
      i = paramInt;
      if (this.aboh != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.aboh);
      }
      i += i.a.a.a.c(5, 8, this.aboi);
      paramInt = i;
      if (this.YNL != null) {
        paramInt = i + i.a.a.a.qC(6, this.YNL.computeSize());
      }
      i = paramInt;
      if (this.VBL != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.VBL);
      }
      AppMethodBeat.o(72554);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aboi.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72554);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72554);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ejp localejp = (ejp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72554);
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
            localejp.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72554);
          return 0;
        case 2: 
          localejp.wuz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(72554);
          return 0;
        case 3: 
          localejp.wuA = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72554);
          return 0;
        case 4: 
          localejp.aboh = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72554);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jp)localObject2).parseFrom((byte[])localObject1);
            }
            localejp.aboi.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72554);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eff();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eff)localObject2).parseFrom((byte[])localObject1);
            }
            localejp.YNL = ((eff)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72554);
          return 0;
        }
        localejp.VBL = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(72554);
        return 0;
      }
      AppMethodBeat.o(72554);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ejp
 * JD-Core Version:    0.7.0.1
 */