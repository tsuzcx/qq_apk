package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gkc
  extends erp
{
  public int ZFJ;
  public String abNC;
  public LinkedList<String> acfY;
  public boolean acfZ;
  public String acga;
  public boolean acgb;
  public boolean acgc;
  public String appid;
  
  public gkc()
  {
    AppMethodBeat.i(153313);
    this.acfY = new LinkedList();
    AppMethodBeat.o(153313);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153314);
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
      paramVarArgs.e(3, 1, this.acfY);
      paramVarArgs.di(4, this.acfZ);
      if (this.acga != null) {
        paramVarArgs.g(5, this.acga);
      }
      paramVarArgs.di(6, this.acgb);
      if (this.abNC != null) {
        paramVarArgs.g(7, this.abNC);
      }
      paramVarArgs.di(8, this.acgc);
      paramVarArgs.bS(9, this.ZFJ);
      AppMethodBeat.o(153314);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label704;
      }
    }
    label704:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.appid != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.appid);
      }
      i = i + i.a.a.a.c(3, 1, this.acfY) + (i.a.a.b.b.a.ko(4) + 1);
      paramInt = i;
      if (this.acga != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.acga);
      }
      i = paramInt + (i.a.a.b.b.a.ko(6) + 1);
      paramInt = i;
      if (this.abNC != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.abNC);
      }
      i = i.a.a.b.b.a.ko(8);
      int j = i.a.a.b.b.a.cJ(9, this.ZFJ);
      AppMethodBeat.o(153314);
      return paramInt + (i + 1) + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.acfY.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(153314);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        gkc localgkc = (gkc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153314);
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
            localgkc.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(153314);
          return 0;
        case 2: 
          localgkc.appid = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(153314);
          return 0;
        case 3: 
          localgkc.acfY.add(((i.a.a.a.a)localObject).ajGk.readString());
          AppMethodBeat.o(153314);
          return 0;
        case 4: 
          localgkc.acfZ = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(153314);
          return 0;
        case 5: 
          localgkc.acga = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(153314);
          return 0;
        case 6: 
          localgkc.acgb = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(153314);
          return 0;
        case 7: 
          localgkc.abNC = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(153314);
          return 0;
        case 8: 
          localgkc.acgc = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(153314);
          return 0;
        }
        localgkc.ZFJ = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(153314);
        return 0;
      }
      AppMethodBeat.o(153314);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gkc
 * JD-Core Version:    0.7.0.1
 */