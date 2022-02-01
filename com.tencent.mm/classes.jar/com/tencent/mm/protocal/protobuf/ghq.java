package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class ghq
  extends com.tencent.mm.bx.a
{
  public LinkedList<gho> aaKS;
  public boolean acdW;
  public boolean acdX;
  public boolean acdY;
  public com.tencent.mm.bx.b acdZ;
  public com.tencent.mm.bx.b acea;
  public String appId;
  public String hOH;
  public int mUU;
  public long pba;
  public boolean rhq;
  public String sMq;
  public String url;
  public String vAY;
  public int vBa;
  public String vBf;
  public String vTu;
  
  public ghq()
  {
    AppMethodBeat.i(258782);
    this.aaKS = new LinkedList();
    AppMethodBeat.o(258782);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258789);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.url == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: url");
        AppMethodBeat.o(258789);
        throw paramVarArgs;
      }
      if (this.url != null) {
        paramVarArgs.g(1, this.url);
      }
      paramVarArgs.bv(2, this.pba);
      paramVarArgs.di(3, this.acdW);
      paramVarArgs.di(4, this.rhq);
      if (this.vTu != null) {
        paramVarArgs.g(5, this.vTu);
      }
      if (this.sMq != null) {
        paramVarArgs.g(6, this.sMq);
      }
      if (this.hOH != null) {
        paramVarArgs.g(7, this.hOH);
      }
      paramVarArgs.di(8, this.acdX);
      paramVarArgs.e(9, 8, this.aaKS);
      paramVarArgs.bS(10, this.mUU);
      paramVarArgs.bS(11, this.vBa);
      if (this.appId != null) {
        paramVarArgs.g(12, this.appId);
      }
      paramVarArgs.di(13, this.acdY);
      if (this.acdZ != null) {
        paramVarArgs.d(14, this.acdZ);
      }
      if (this.vBf != null) {
        paramVarArgs.g(15, this.vBf);
      }
      if (this.acea != null) {
        paramVarArgs.d(16, this.acea);
      }
      if (this.vAY != null) {
        paramVarArgs.g(17, this.vAY);
      }
      AppMethodBeat.o(258789);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label1176;
      }
    }
    label1176:
    for (paramInt = i.a.a.b.b.a.h(1, this.url) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.pba) + (i.a.a.b.b.a.ko(3) + 1) + (i.a.a.b.b.a.ko(4) + 1);
      paramInt = i;
      if (this.vTu != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.vTu);
      }
      i = paramInt;
      if (this.sMq != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.sMq);
      }
      paramInt = i;
      if (this.hOH != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.hOH);
      }
      i = paramInt + (i.a.a.b.b.a.ko(8) + 1) + i.a.a.a.c(9, 8, this.aaKS) + i.a.a.b.b.a.cJ(10, this.mUU) + i.a.a.b.b.a.cJ(11, this.vBa);
      paramInt = i;
      if (this.appId != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.appId);
      }
      i = paramInt + (i.a.a.b.b.a.ko(13) + 1);
      paramInt = i;
      if (this.acdZ != null) {
        paramInt = i + i.a.a.b.b.a.c(14, this.acdZ);
      }
      i = paramInt;
      if (this.vBf != null) {
        i = paramInt + i.a.a.b.b.a.h(15, this.vBf);
      }
      paramInt = i;
      if (this.acea != null) {
        paramInt = i + i.a.a.b.b.a.c(16, this.acea);
      }
      i = paramInt;
      if (this.vAY != null) {
        i = paramInt + i.a.a.b.b.a.h(17, this.vAY);
      }
      AppMethodBeat.o(258789);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aaKS.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.url == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: url");
          AppMethodBeat.o(258789);
          throw paramVarArgs;
        }
        AppMethodBeat.o(258789);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ghq localghq = (ghq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258789);
          return -1;
        case 1: 
          localghq.url = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258789);
          return 0;
        case 2: 
          localghq.pba = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(258789);
          return 0;
        case 3: 
          localghq.acdW = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(258789);
          return 0;
        case 4: 
          localghq.rhq = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(258789);
          return 0;
        case 5: 
          localghq.vTu = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258789);
          return 0;
        case 6: 
          localghq.sMq = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258789);
          return 0;
        case 7: 
          localghq.hOH = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258789);
          return 0;
        case 8: 
          localghq.acdX = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(258789);
          return 0;
        case 9: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            gho localgho = new gho();
            if ((localObject != null) && (localObject.length > 0)) {
              localgho.parseFrom((byte[])localObject);
            }
            localghq.aaKS.add(localgho);
            paramInt += 1;
          }
          AppMethodBeat.o(258789);
          return 0;
        case 10: 
          localghq.mUU = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258789);
          return 0;
        case 11: 
          localghq.vBa = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258789);
          return 0;
        case 12: 
          localghq.appId = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258789);
          return 0;
        case 13: 
          localghq.acdY = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(258789);
          return 0;
        case 14: 
          localghq.acdZ = ((i.a.a.a.a)localObject).ajGk.kFX();
          AppMethodBeat.o(258789);
          return 0;
        case 15: 
          localghq.vBf = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258789);
          return 0;
        case 16: 
          localghq.acea = ((i.a.a.a.a)localObject).ajGk.kFX();
          AppMethodBeat.o(258789);
          return 0;
        }
        localghq.vAY = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(258789);
        return 0;
      }
      AppMethodBeat.o(258789);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ghq
 * JD-Core Version:    0.7.0.1
 */