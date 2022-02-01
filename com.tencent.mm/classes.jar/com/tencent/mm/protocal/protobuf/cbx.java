package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cbx
  extends com.tencent.mm.bx.a
{
  public String aakg;
  public int aakj;
  public gfg aakk;
  public String aalj;
  public int app_status;
  public String appid;
  public String icon_url;
  public String lwO;
  public String nSt;
  public String xlr;
  public long xls;
  public String xlt;
  public int xlv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258084);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.appid != null) {
        paramVarArgs.g(1, this.appid);
      }
      if (this.nSt != null) {
        paramVarArgs.g(2, this.nSt);
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
      paramVarArgs.bS(11, this.aakj);
      if (this.aakk != null)
      {
        paramVarArgs.qD(12, this.aakk.computeSize());
        this.aakk.writeFields(paramVarArgs);
      }
      if (this.aalj != null) {
        paramVarArgs.g(13, this.aalj);
      }
      AppMethodBeat.o(258084);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appid == null) {
        break label956;
      }
    }
    label956:
    for (int i = i.a.a.b.b.a.h(1, this.appid) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nSt != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.nSt);
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
      i = paramInt + i.a.a.b.b.a.cJ(11, this.aakj);
      paramInt = i;
      if (this.aakk != null) {
        paramInt = i + i.a.a.a.qC(12, this.aakk.computeSize());
      }
      i = paramInt;
      if (this.aalj != null) {
        i = paramInt + i.a.a.b.b.a.h(13, this.aalj);
      }
      AppMethodBeat.o(258084);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258084);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        cbx localcbx = (cbx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258084);
          return -1;
        case 1: 
          localcbx.appid = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258084);
          return 0;
        case 2: 
          localcbx.nSt = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258084);
          return 0;
        case 3: 
          localcbx.icon_url = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258084);
          return 0;
        case 4: 
          localcbx.lwO = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258084);
          return 0;
        case 5: 
          localcbx.xlr = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258084);
          return 0;
        case 6: 
          localcbx.xls = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(258084);
          return 0;
        case 7: 
          localcbx.xlt = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258084);
          return 0;
        case 8: 
          localcbx.xlv = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258084);
          return 0;
        case 9: 
          localcbx.app_status = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258084);
          return 0;
        case 10: 
          localcbx.aakg = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258084);
          return 0;
        case 11: 
          localcbx.aakj = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258084);
          return 0;
        case 12: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            gfg localgfg = new gfg();
            if ((localObject != null) && (localObject.length > 0)) {
              localgfg.parseFrom((byte[])localObject);
            }
            localcbx.aakk = localgfg;
            paramInt += 1;
          }
          AppMethodBeat.o(258084);
          return 0;
        }
        localcbx.aalj = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(258084);
        return 0;
      }
      AppMethodBeat.o(258084);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbx
 * JD-Core Version:    0.7.0.1
 */