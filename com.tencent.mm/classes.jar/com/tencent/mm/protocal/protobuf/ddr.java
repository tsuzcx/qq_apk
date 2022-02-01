package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ddr
  extends erp
{
  public String aaIL;
  public String aaIM;
  public String aaIP;
  public int aaIQ;
  public LinkedList<String> aaJh;
  public String aaJi;
  public LinkedList<String> aaJj;
  public int aaJk;
  public String appid;
  public String hhx;
  public int scene;
  public String signature;
  public String url;
  
  public ddr()
  {
    AppMethodBeat.i(82438);
    this.aaJh = new LinkedList();
    this.aaJj = new LinkedList();
    AppMethodBeat.o(82438);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82439);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.g(2, this.url);
      }
      if (this.appid != null) {
        paramVarArgs.g(3, this.appid);
      }
      paramVarArgs.e(4, 1, this.aaJh);
      if (this.hhx != null) {
        paramVarArgs.g(5, this.hhx);
      }
      if (this.aaIL != null) {
        paramVarArgs.g(6, this.aaIL);
      }
      if (this.signature != null) {
        paramVarArgs.g(7, this.signature);
      }
      if (this.aaIM != null) {
        paramVarArgs.g(8, this.aaIM);
      }
      paramVarArgs.bS(9, this.scene);
      if (this.aaJi != null) {
        paramVarArgs.g(10, this.aaJi);
      }
      paramVarArgs.e(11, 1, this.aaJj);
      if (this.aaIP != null) {
        paramVarArgs.g(12, this.aaIP);
      }
      paramVarArgs.bS(13, this.aaJk);
      paramVarArgs.bS(14, this.aaIQ);
      AppMethodBeat.o(82439);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1032;
      }
    }
    label1032:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.url);
      }
      i = paramInt;
      if (this.appid != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.appid);
      }
      i += i.a.a.a.c(4, 1, this.aaJh);
      paramInt = i;
      if (this.hhx != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.hhx);
      }
      i = paramInt;
      if (this.aaIL != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.aaIL);
      }
      paramInt = i;
      if (this.signature != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.signature);
      }
      i = paramInt;
      if (this.aaIM != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.aaIM);
      }
      i += i.a.a.b.b.a.cJ(9, this.scene);
      paramInt = i;
      if (this.aaJi != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.aaJi);
      }
      i = paramInt + i.a.a.a.c(11, 1, this.aaJj);
      paramInt = i;
      if (this.aaIP != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.aaIP);
      }
      i = i.a.a.b.b.a.cJ(13, this.aaJk);
      int j = i.a.a.b.b.a.cJ(14, this.aaIQ);
      AppMethodBeat.o(82439);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aaJh.clear();
        this.aaJj.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(82439);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ddr localddr = (ddr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82439);
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
            localddr.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(82439);
          return 0;
        case 2: 
          localddr.url = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(82439);
          return 0;
        case 3: 
          localddr.appid = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(82439);
          return 0;
        case 4: 
          localddr.aaJh.add(((i.a.a.a.a)localObject).ajGk.readString());
          AppMethodBeat.o(82439);
          return 0;
        case 5: 
          localddr.hhx = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(82439);
          return 0;
        case 6: 
          localddr.aaIL = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(82439);
          return 0;
        case 7: 
          localddr.signature = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(82439);
          return 0;
        case 8: 
          localddr.aaIM = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(82439);
          return 0;
        case 9: 
          localddr.scene = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(82439);
          return 0;
        case 10: 
          localddr.aaJi = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(82439);
          return 0;
        case 11: 
          localddr.aaJj.add(((i.a.a.a.a)localObject).ajGk.readString());
          AppMethodBeat.o(82439);
          return 0;
        case 12: 
          localddr.aaIP = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(82439);
          return 0;
        case 13: 
          localddr.aaJk = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(82439);
          return 0;
        }
        localddr.aaIQ = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(82439);
        return 0;
      }
      AppMethodBeat.o(82439);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddr
 * JD-Core Version:    0.7.0.1
 */