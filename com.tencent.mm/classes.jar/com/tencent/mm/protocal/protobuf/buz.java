package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class buz
  extends erp
{
  public b BgS;
  public atz CJv;
  public b ZZM;
  public b aacn;
  public b aaco;
  public String hOG;
  public int offset;
  public String query;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169048);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.query != null) {
        paramVarArgs.g(2, this.query);
      }
      paramVarArgs.bS(3, this.offset);
      if (this.BgS != null) {
        paramVarArgs.d(4, this.BgS);
      }
      paramVarArgs.bS(5, this.scene);
      if (this.hOG != null) {
        paramVarArgs.g(6, this.hOG);
      }
      if (this.CJv != null)
      {
        paramVarArgs.qD(7, this.CJv.computeSize());
        this.CJv.writeFields(paramVarArgs);
      }
      if (this.aacn != null) {
        paramVarArgs.d(8, this.aacn);
      }
      if (this.ZZM != null) {
        paramVarArgs.d(9, this.ZZM);
      }
      if (this.aaco != null) {
        paramVarArgs.d(10, this.aaco);
      }
      AppMethodBeat.o(169048);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label874;
      }
    }
    label874:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.query != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.query);
      }
      i += i.a.a.b.b.a.cJ(3, this.offset);
      paramInt = i;
      if (this.BgS != null) {
        paramInt = i + i.a.a.b.b.a.c(4, this.BgS);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.scene);
      paramInt = i;
      if (this.hOG != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.hOG);
      }
      i = paramInt;
      if (this.CJv != null) {
        i = paramInt + i.a.a.a.qC(7, this.CJv.computeSize());
      }
      paramInt = i;
      if (this.aacn != null) {
        paramInt = i + i.a.a.b.b.a.c(8, this.aacn);
      }
      i = paramInt;
      if (this.ZZM != null) {
        i = paramInt + i.a.a.b.b.a.c(9, this.ZZM);
      }
      paramInt = i;
      if (this.aaco != null) {
        paramInt = i + i.a.a.b.b.a.c(10, this.aaco);
      }
      AppMethodBeat.o(169048);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(169048);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        buz localbuz = (buz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169048);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localbuz.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169048);
          return 0;
        case 2: 
          localbuz.query = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169048);
          return 0;
        case 3: 
          localbuz.offset = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169048);
          return 0;
        case 4: 
          localbuz.BgS = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(169048);
          return 0;
        case 5: 
          localbuz.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169048);
          return 0;
        case 6: 
          localbuz.hOG = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169048);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new atz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((atz)localObject2).parseFrom((byte[])localObject1);
            }
            localbuz.CJv = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169048);
          return 0;
        case 8: 
          localbuz.aacn = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(169048);
          return 0;
        case 9: 
          localbuz.ZZM = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(169048);
          return 0;
        }
        localbuz.aaco = ((i.a.a.a.a)localObject1).ajGk.kFX();
        AppMethodBeat.o(169048);
        return 0;
      }
      AppMethodBeat.o(169048);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.buz
 * JD-Core Version:    0.7.0.1
 */