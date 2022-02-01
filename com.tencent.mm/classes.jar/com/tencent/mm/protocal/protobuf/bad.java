package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bad
  extends esc
{
  public LinkedList<bnn> ZKV;
  public biy ZKW;
  public int ZKX;
  public int ZKY;
  public int ZKZ;
  public int ZLa;
  public int ZLb;
  public LinkedList<bnn> ZLc;
  public String title;
  
  public bad()
  {
    AppMethodBeat.i(260258);
    this.ZKV = new LinkedList();
    this.ZLc = new LinkedList();
    AppMethodBeat.o(260258);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260263);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.ZKV);
      if (this.ZKW != null)
      {
        paramVarArgs.qD(3, this.ZKW.computeSize());
        this.ZKW.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(4, this.ZKX);
      paramVarArgs.bS(5, this.ZKY);
      paramVarArgs.bS(6, this.ZKZ);
      paramVarArgs.bS(7, this.ZLa);
      if (this.title != null) {
        paramVarArgs.g(8, this.title);
      }
      paramVarArgs.bS(9, this.ZLb);
      paramVarArgs.e(10, 8, this.ZLc);
      AppMethodBeat.o(260263);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label938;
      }
    }
    label938:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.ZKV);
      paramInt = i;
      if (this.ZKW != null) {
        paramInt = i + i.a.a.a.qC(3, this.ZKW.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.ZKX) + i.a.a.b.b.a.cJ(5, this.ZKY) + i.a.a.b.b.a.cJ(6, this.ZKZ) + i.a.a.b.b.a.cJ(7, this.ZLa);
      paramInt = i;
      if (this.title != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.title);
      }
      i = i.a.a.b.b.a.cJ(9, this.ZLb);
      int j = i.a.a.a.c(10, 8, this.ZLc);
      AppMethodBeat.o(260263);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZKV.clear();
        this.ZLc.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(260263);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bad localbad = (bad)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(260263);
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
            localbad.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260263);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bnn();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bnn)localObject2).parseFrom((byte[])localObject1);
            }
            localbad.ZKV.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260263);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new biy();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((biy)localObject2).parseFrom((byte[])localObject1);
            }
            localbad.ZKW = ((biy)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260263);
          return 0;
        case 4: 
          localbad.ZKX = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(260263);
          return 0;
        case 5: 
          localbad.ZKY = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(260263);
          return 0;
        case 6: 
          localbad.ZKZ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(260263);
          return 0;
        case 7: 
          localbad.ZLa = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(260263);
          return 0;
        case 8: 
          localbad.title = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(260263);
          return 0;
        case 9: 
          localbad.ZLb = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(260263);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bnn();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bnn)localObject2).parseFrom((byte[])localObject1);
          }
          localbad.ZLc.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(260263);
        return 0;
      }
      AppMethodBeat.o(260263);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bad
 * JD-Core Version:    0.7.0.1
 */