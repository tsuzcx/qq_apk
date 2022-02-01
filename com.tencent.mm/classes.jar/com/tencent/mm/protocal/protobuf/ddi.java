package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ddi
  extends erp
{
  public int ZFJ;
  public String ZFM;
  public int aaIQ;
  public String aaIV;
  public String aaIW;
  public int aaIX;
  public String aaIY;
  public String aaIZ;
  public String aaJa;
  public String appid;
  public String packageName;
  public int scene;
  public String url;
  public int wYK;
  public String wwH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123602);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.appid != null) {
        paramVarArgs.g(2, this.appid);
      }
      if (this.aaIV != null) {
        paramVarArgs.g(3, this.aaIV);
      }
      paramVarArgs.bS(4, this.scene);
      if (this.url != null) {
        paramVarArgs.g(5, this.url);
      }
      if (this.aaIW != null) {
        paramVarArgs.g(6, this.aaIW);
      }
      paramVarArgs.bS(7, this.wYK);
      paramVarArgs.bS(8, this.ZFJ);
      paramVarArgs.bS(9, this.aaIX);
      if (this.aaIY != null) {
        paramVarArgs.g(10, this.aaIY);
      }
      if (this.packageName != null) {
        paramVarArgs.g(11, this.packageName);
      }
      if (this.aaIZ != null) {
        paramVarArgs.g(12, this.aaIZ);
      }
      paramVarArgs.bS(13, this.aaIQ);
      if (this.wwH != null) {
        paramVarArgs.g(14, this.wwH);
      }
      if (this.ZFM != null) {
        paramVarArgs.g(15, this.ZFM);
      }
      if (this.aaJa != null) {
        paramVarArgs.g(16, this.aaJa);
      }
      AppMethodBeat.o(123602);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1124;
      }
    }
    label1124:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.appid != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.appid);
      }
      i = paramInt;
      if (this.aaIV != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aaIV);
      }
      i += i.a.a.b.b.a.cJ(4, this.scene);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.url);
      }
      i = paramInt;
      if (this.aaIW != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.aaIW);
      }
      i = i + i.a.a.b.b.a.cJ(7, this.wYK) + i.a.a.b.b.a.cJ(8, this.ZFJ) + i.a.a.b.b.a.cJ(9, this.aaIX);
      paramInt = i;
      if (this.aaIY != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.aaIY);
      }
      i = paramInt;
      if (this.packageName != null) {
        i = paramInt + i.a.a.b.b.a.h(11, this.packageName);
      }
      paramInt = i;
      if (this.aaIZ != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.aaIZ);
      }
      i = paramInt + i.a.a.b.b.a.cJ(13, this.aaIQ);
      paramInt = i;
      if (this.wwH != null) {
        paramInt = i + i.a.a.b.b.a.h(14, this.wwH);
      }
      i = paramInt;
      if (this.ZFM != null) {
        i = paramInt + i.a.a.b.b.a.h(15, this.ZFM);
      }
      paramInt = i;
      if (this.aaJa != null) {
        paramInt = i + i.a.a.b.b.a.h(16, this.aaJa);
      }
      AppMethodBeat.o(123602);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(123602);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ddi localddi = (ddi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123602);
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
            localddi.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(123602);
          return 0;
        case 2: 
          localddi.appid = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(123602);
          return 0;
        case 3: 
          localddi.aaIV = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(123602);
          return 0;
        case 4: 
          localddi.scene = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(123602);
          return 0;
        case 5: 
          localddi.url = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(123602);
          return 0;
        case 6: 
          localddi.aaIW = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(123602);
          return 0;
        case 7: 
          localddi.wYK = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(123602);
          return 0;
        case 8: 
          localddi.ZFJ = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(123602);
          return 0;
        case 9: 
          localddi.aaIX = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(123602);
          return 0;
        case 10: 
          localddi.aaIY = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(123602);
          return 0;
        case 11: 
          localddi.packageName = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(123602);
          return 0;
        case 12: 
          localddi.aaIZ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(123602);
          return 0;
        case 13: 
          localddi.aaIQ = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(123602);
          return 0;
        case 14: 
          localddi.wwH = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(123602);
          return 0;
        case 15: 
          localddi.ZFM = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(123602);
          return 0;
        }
        localddi.aaJa = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(123602);
        return 0;
      }
      AppMethodBeat.o(123602);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddi
 * JD-Core Version:    0.7.0.1
 */