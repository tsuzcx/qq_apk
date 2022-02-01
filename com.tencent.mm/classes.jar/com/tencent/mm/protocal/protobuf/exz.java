package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class exz
  extends erp
{
  public String YJR;
  public LinkedList<Integer> abqA;
  public String abzy;
  public String abzz;
  public String appid;
  public String hAk;
  public String hFb;
  
  public exz()
  {
    AppMethodBeat.i(123645);
    this.abqA = new LinkedList();
    AppMethodBeat.o(123645);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123646);
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
      paramVarArgs.e(3, 2, this.abqA);
      if (this.abzy != null) {
        paramVarArgs.g(4, this.abzy);
      }
      if (this.YJR != null) {
        paramVarArgs.g(5, this.YJR);
      }
      if (this.hFb != null) {
        paramVarArgs.g(6, this.hFb);
      }
      if (this.hAk != null) {
        paramVarArgs.g(7, this.hAk);
      }
      if (this.abzz != null) {
        paramVarArgs.g(8, this.abzz);
      }
      AppMethodBeat.o(123646);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label715;
      }
    }
    label715:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.appid != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.appid);
      }
      i += i.a.a.a.c(3, 2, this.abqA);
      paramInt = i;
      if (this.abzy != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abzy);
      }
      i = paramInt;
      if (this.YJR != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.YJR);
      }
      paramInt = i;
      if (this.hFb != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.hFb);
      }
      i = paramInt;
      if (this.hAk != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.hAk);
      }
      paramInt = i;
      if (this.abzz != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.abzz);
      }
      AppMethodBeat.o(123646);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abqA.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(123646);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        exz localexz = (exz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123646);
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
            localexz.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(123646);
          return 0;
        case 2: 
          localexz.appid = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(123646);
          return 0;
        case 3: 
          localexz.abqA.add(Integer.valueOf(((i.a.a.a.a)localObject).ajGk.aar()));
          AppMethodBeat.o(123646);
          return 0;
        case 4: 
          localexz.abzy = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(123646);
          return 0;
        case 5: 
          localexz.YJR = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(123646);
          return 0;
        case 6: 
          localexz.hFb = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(123646);
          return 0;
        case 7: 
          localexz.hAk = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(123646);
          return 0;
        }
        localexz.abzz = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(123646);
        return 0;
      }
      AppMethodBeat.o(123646);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.exz
 * JD-Core Version:    0.7.0.1
 */