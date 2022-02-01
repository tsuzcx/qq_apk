package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class cen
  extends erp
{
  public int aaoA;
  public String app_id;
  public int time_stamp;
  public int wDd;
  public String wDe;
  public String wDf;
  public String wDg;
  public String wDh;
  public String wsy;
  public b wuZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114000);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.app_id != null) {
        paramVarArgs.g(2, this.app_id);
      }
      paramVarArgs.bS(3, this.wDd);
      if (this.wDe != null) {
        paramVarArgs.g(4, this.wDe);
      }
      if (this.wDf != null) {
        paramVarArgs.g(5, this.wDf);
      }
      paramVarArgs.bS(6, this.time_stamp);
      if (this.wDg != null) {
        paramVarArgs.g(7, this.wDg);
      }
      if (this.wsy != null) {
        paramVarArgs.g(8, this.wsy);
      }
      if (this.wDh != null) {
        paramVarArgs.g(9, this.wDh);
      }
      if (this.wuZ != null) {
        paramVarArgs.d(10, this.wuZ);
      }
      paramVarArgs.bS(11, this.aaoA);
      AppMethodBeat.o(114000);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label848;
      }
    }
    label848:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.app_id != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.app_id);
      }
      i += i.a.a.b.b.a.cJ(3, this.wDd);
      paramInt = i;
      if (this.wDe != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.wDe);
      }
      i = paramInt;
      if (this.wDf != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.wDf);
      }
      i += i.a.a.b.b.a.cJ(6, this.time_stamp);
      paramInt = i;
      if (this.wDg != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.wDg);
      }
      i = paramInt;
      if (this.wsy != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.wsy);
      }
      paramInt = i;
      if (this.wDh != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.wDh);
      }
      i = paramInt;
      if (this.wuZ != null) {
        i = paramInt + i.a.a.b.b.a.c(10, this.wuZ);
      }
      paramInt = i.a.a.b.b.a.cJ(11, this.aaoA);
      AppMethodBeat.o(114000);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(114000);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        cen localcen = (cen)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114000);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kc localkc = new kc();
            if ((localObject != null) && (localObject.length > 0)) {
              localkc.parseFrom((byte[])localObject);
            }
            localcen.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(114000);
          return 0;
        case 2: 
          localcen.app_id = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114000);
          return 0;
        case 3: 
          localcen.wDd = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(114000);
          return 0;
        case 4: 
          localcen.wDe = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114000);
          return 0;
        case 5: 
          localcen.wDf = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114000);
          return 0;
        case 6: 
          localcen.time_stamp = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(114000);
          return 0;
        case 7: 
          localcen.wDg = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114000);
          return 0;
        case 8: 
          localcen.wsy = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114000);
          return 0;
        case 9: 
          localcen.wDh = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114000);
          return 0;
        case 10: 
          localcen.wuZ = ((i.a.a.a.a)localObject).ajGk.kFX();
          AppMethodBeat.o(114000);
          return 0;
        }
        localcen.aaoA = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(114000);
        return 0;
      }
      AppMethodBeat.o(114000);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cen
 * JD-Core Version:    0.7.0.1
 */