package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cbb
  extends com.tencent.mm.bx.a
{
  public int ZQz;
  public boolean ZXv;
  public String aakg;
  public int aakh;
  public cbr aaki;
  public int aakj;
  public gfg aakk;
  public int aakl;
  public String aakm;
  public String app_id;
  public int app_status;
  public String icon_url;
  public String lwO;
  public String xlJ;
  public String xlr;
  public long xls;
  public String xlt;
  public int xlv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258423);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.app_id != null) {
        paramVarArgs.g(1, this.app_id);
      }
      if (this.xlJ != null) {
        paramVarArgs.g(2, this.xlJ);
      }
      if (this.icon_url != null) {
        paramVarArgs.g(3, this.icon_url);
      }
      if (this.lwO != null) {
        paramVarArgs.g(4, this.lwO);
      }
      if (this.xlr != null) {
        paramVarArgs.g(5, this.xlr);
      }
      paramVarArgs.bv(6, this.xls);
      if (this.xlt != null) {
        paramVarArgs.g(7, this.xlt);
      }
      paramVarArgs.bS(8, this.xlv);
      paramVarArgs.bS(9, this.app_status);
      if (this.aakg != null) {
        paramVarArgs.g(10, this.aakg);
      }
      paramVarArgs.bS(11, this.aakh);
      if (this.aaki != null)
      {
        paramVarArgs.qD(12, this.aaki.computeSize());
        this.aaki.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(13, this.ZQz);
      paramVarArgs.bS(14, this.aakj);
      if (this.aakk != null)
      {
        paramVarArgs.qD(15, this.aakk.computeSize());
        this.aakk.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(16, this.aakl);
      paramVarArgs.di(17, this.ZXv);
      if (this.aakm != null) {
        paramVarArgs.g(18, this.aakm);
      }
      AppMethodBeat.o(258423);
      return 0;
    }
    if (paramInt == 1) {
      if (this.app_id == null) {
        break label1266;
      }
    }
    label1266:
    for (int i = i.a.a.b.b.a.h(1, this.app_id) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xlJ != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.xlJ);
      }
      i = paramInt;
      if (this.icon_url != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.icon_url);
      }
      paramInt = i;
      if (this.lwO != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.lwO);
      }
      i = paramInt;
      if (this.xlr != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.xlr);
      }
      i += i.a.a.b.b.a.q(6, this.xls);
      paramInt = i;
      if (this.xlt != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.xlt);
      }
      i = paramInt + i.a.a.b.b.a.cJ(8, this.xlv) + i.a.a.b.b.a.cJ(9, this.app_status);
      paramInt = i;
      if (this.aakg != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.aakg);
      }
      i = paramInt + i.a.a.b.b.a.cJ(11, this.aakh);
      paramInt = i;
      if (this.aaki != null) {
        paramInt = i + i.a.a.a.qC(12, this.aaki.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(13, this.ZQz) + i.a.a.b.b.a.cJ(14, this.aakj);
      paramInt = i;
      if (this.aakk != null) {
        paramInt = i + i.a.a.a.qC(15, this.aakk.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(16, this.aakl) + (i.a.a.b.b.a.ko(17) + 1);
      paramInt = i;
      if (this.aakm != null) {
        paramInt = i + i.a.a.b.b.a.h(18, this.aakm);
      }
      AppMethodBeat.o(258423);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258423);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cbb localcbb = (cbb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258423);
          return -1;
        case 1: 
          localcbb.app_id = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258423);
          return 0;
        case 2: 
          localcbb.xlJ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258423);
          return 0;
        case 3: 
          localcbb.icon_url = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258423);
          return 0;
        case 4: 
          localcbb.lwO = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258423);
          return 0;
        case 5: 
          localcbb.xlr = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258423);
          return 0;
        case 6: 
          localcbb.xls = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(258423);
          return 0;
        case 7: 
          localcbb.xlt = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258423);
          return 0;
        case 8: 
          localcbb.xlv = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258423);
          return 0;
        case 9: 
          localcbb.app_status = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258423);
          return 0;
        case 10: 
          localcbb.aakg = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258423);
          return 0;
        case 11: 
          localcbb.aakh = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258423);
          return 0;
        case 12: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cbr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cbr)localObject2).parseFrom((byte[])localObject1);
            }
            localcbb.aaki = ((cbr)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258423);
          return 0;
        case 13: 
          localcbb.ZQz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258423);
          return 0;
        case 14: 
          localcbb.aakj = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258423);
          return 0;
        case 15: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gfg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gfg)localObject2).parseFrom((byte[])localObject1);
            }
            localcbb.aakk = ((gfg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258423);
          return 0;
        case 16: 
          localcbb.aakl = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258423);
          return 0;
        case 17: 
          localcbb.ZXv = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(258423);
          return 0;
        }
        localcbb.aakm = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(258423);
        return 0;
      }
      AppMethodBeat.o(258423);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbb
 * JD-Core Version:    0.7.0.1
 */