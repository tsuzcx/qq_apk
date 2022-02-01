package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ckj
  extends esc
{
  public LinkedList<dl> YFQ;
  public int YIq;
  public long aanC;
  public String aasG;
  public tb aasH;
  public dl aasI;
  public int aasJ;
  
  public ckj()
  {
    AppMethodBeat.i(258199);
    this.YFQ = new LinkedList();
    AppMethodBeat.o(258199);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114788);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(114788);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.YIq);
      paramVarArgs.bv(3, this.aanC);
      if (this.aasI != null)
      {
        paramVarArgs.qD(4, this.aasI.computeSize());
        this.aasI.writeFields(paramVarArgs);
      }
      if (this.aasG != null) {
        paramVarArgs.g(5, this.aasG);
      }
      paramVarArgs.bS(6, this.aasJ);
      if (this.aasH != null)
      {
        paramVarArgs.qD(7, this.aasH.computeSize());
        this.aasH.writeFields(paramVarArgs);
      }
      paramVarArgs.e(8, 8, this.YFQ);
      AppMethodBeat.o(114788);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label914;
      }
    }
    label914:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.YIq) + i.a.a.b.b.a.q(3, this.aanC);
      paramInt = i;
      if (this.aasI != null) {
        paramInt = i + i.a.a.a.qC(4, this.aasI.computeSize());
      }
      i = paramInt;
      if (this.aasG != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.aasG);
      }
      i += i.a.a.b.b.a.cJ(6, this.aasJ);
      paramInt = i;
      if (this.aasH != null) {
        paramInt = i + i.a.a.a.qC(7, this.aasH.computeSize());
      }
      i = i.a.a.a.c(8, 8, this.YFQ);
      AppMethodBeat.o(114788);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YFQ.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(114788);
          throw paramVarArgs;
        }
        AppMethodBeat.o(114788);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ckj localckj = (ckj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114788);
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
            localckj.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(114788);
          return 0;
        case 2: 
          localckj.YIq = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(114788);
          return 0;
        case 3: 
          localckj.aanC = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(114788);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dl)localObject2).parseFrom((byte[])localObject1);
            }
            localckj.aasI = ((dl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(114788);
          return 0;
        case 5: 
          localckj.aasG = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(114788);
          return 0;
        case 6: 
          localckj.aasJ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(114788);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new tb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((tb)localObject2).parseFrom((byte[])localObject1);
            }
            localckj.aasH = ((tb)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(114788);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dl();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dl)localObject2).parseFrom((byte[])localObject1);
          }
          localckj.YFQ.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(114788);
        return 0;
      }
      AppMethodBeat.o(114788);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ckj
 * JD-Core Version:    0.7.0.1
 */