package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fjs
  extends erp
{
  public LinkedList<Integer> abqA;
  public String abzy;
  public String abzz;
  public String appid;
  public String hFb;
  
  public fjs()
  {
    AppMethodBeat.i(123656);
    this.abqA = new LinkedList();
    AppMethodBeat.o(123656);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123657);
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
      if (this.hFb != null) {
        paramVarArgs.g(5, this.hFb);
      }
      if (this.abzz != null) {
        paramVarArgs.g(6, this.abzz);
      }
      AppMethodBeat.o(123657);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label591;
      }
    }
    label591:
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
      if (this.hFb != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.hFb);
      }
      paramInt = i;
      if (this.abzz != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.abzz);
      }
      AppMethodBeat.o(123657);
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
        AppMethodBeat.o(123657);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fjs localfjs = (fjs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123657);
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
            localfjs.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(123657);
          return 0;
        case 2: 
          localfjs.appid = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(123657);
          return 0;
        case 3: 
          localfjs.abqA.add(Integer.valueOf(((i.a.a.a.a)localObject).ajGk.aar()));
          AppMethodBeat.o(123657);
          return 0;
        case 4: 
          localfjs.abzy = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(123657);
          return 0;
        case 5: 
          localfjs.hFb = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(123657);
          return 0;
        }
        localfjs.abzz = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(123657);
        return 0;
      }
      AppMethodBeat.o(123657);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fjs
 * JD-Core Version:    0.7.0.1
 */