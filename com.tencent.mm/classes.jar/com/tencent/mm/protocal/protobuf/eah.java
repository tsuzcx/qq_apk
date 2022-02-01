package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eah
  extends com.tencent.mm.bx.a
{
  public int abfr = 0;
  public String abfs;
  public int abft = -1;
  public eae abfu;
  public String abfv = "";
  public boolean abfw = false;
  public String abfx = "";
  public boolean abfy = false;
  public int abfz = 0;
  public long endTime = 0L;
  public int owq = -1;
  public String qkQ = "";
  public long seq = 0L;
  public String sessionId;
  public long startTime = 0L;
  public String userName = "";
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122525);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.sessionId != null) {
        paramVarArgs.g(1, this.sessionId);
      }
      paramVarArgs.bv(2, this.seq);
      paramVarArgs.bS(3, this.abfr);
      if (this.abfs != null) {
        paramVarArgs.g(4, this.abfs);
      }
      paramVarArgs.bS(5, this.abft);
      paramVarArgs.bv(6, this.startTime);
      paramVarArgs.bv(7, this.endTime);
      if (this.abfu != null)
      {
        paramVarArgs.qD(8, this.abfu.computeSize());
        this.abfu.writeFields(paramVarArgs);
      }
      if (this.abfv != null) {
        paramVarArgs.g(9, this.abfv);
      }
      paramVarArgs.di(10, this.abfw);
      if (this.userName != null) {
        paramVarArgs.g(11, this.userName);
      }
      if (this.abfx != null) {
        paramVarArgs.g(12, this.abfx);
      }
      paramVarArgs.bS(13, this.owq);
      paramVarArgs.di(14, this.abfy);
      paramVarArgs.bS(15, this.abfz);
      if (this.qkQ != null) {
        paramVarArgs.g(16, this.qkQ);
      }
      AppMethodBeat.o(122525);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sessionId == null) {
        break label1048;
      }
    }
    label1048:
    for (paramInt = i.a.a.b.b.a.h(1, this.sessionId) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.seq) + i.a.a.b.b.a.cJ(3, this.abfr);
      paramInt = i;
      if (this.abfs != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abfs);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.abft) + i.a.a.b.b.a.q(6, this.startTime) + i.a.a.b.b.a.q(7, this.endTime);
      paramInt = i;
      if (this.abfu != null) {
        paramInt = i + i.a.a.a.qC(8, this.abfu.computeSize());
      }
      i = paramInt;
      if (this.abfv != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.abfv);
      }
      i += i.a.a.b.b.a.ko(10) + 1;
      paramInt = i;
      if (this.userName != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.userName);
      }
      i = paramInt;
      if (this.abfx != null) {
        i = paramInt + i.a.a.b.b.a.h(12, this.abfx);
      }
      i = i + i.a.a.b.b.a.cJ(13, this.owq) + (i.a.a.b.b.a.ko(14) + 1) + i.a.a.b.b.a.cJ(15, this.abfz);
      paramInt = i;
      if (this.qkQ != null) {
        paramInt = i + i.a.a.b.b.a.h(16, this.qkQ);
      }
      AppMethodBeat.o(122525);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(122525);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        eah localeah = (eah)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122525);
          return -1;
        case 1: 
          localeah.sessionId = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(122525);
          return 0;
        case 2: 
          localeah.seq = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(122525);
          return 0;
        case 3: 
          localeah.abfr = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(122525);
          return 0;
        case 4: 
          localeah.abfs = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(122525);
          return 0;
        case 5: 
          localeah.abft = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(122525);
          return 0;
        case 6: 
          localeah.startTime = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(122525);
          return 0;
        case 7: 
          localeah.endTime = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(122525);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            eae localeae = new eae();
            if ((localObject != null) && (localObject.length > 0)) {
              localeae.parseFrom((byte[])localObject);
            }
            localeah.abfu = localeae;
            paramInt += 1;
          }
          AppMethodBeat.o(122525);
          return 0;
        case 9: 
          localeah.abfv = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(122525);
          return 0;
        case 10: 
          localeah.abfw = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(122525);
          return 0;
        case 11: 
          localeah.userName = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(122525);
          return 0;
        case 12: 
          localeah.abfx = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(122525);
          return 0;
        case 13: 
          localeah.owq = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(122525);
          return 0;
        case 14: 
          localeah.abfy = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(122525);
          return 0;
        case 15: 
          localeah.abfz = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(122525);
          return 0;
        }
        localeah.qkQ = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(122525);
        return 0;
      }
      AppMethodBeat.o(122525);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eah
 * JD-Core Version:    0.7.0.1
 */