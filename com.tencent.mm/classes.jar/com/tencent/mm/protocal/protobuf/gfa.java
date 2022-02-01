package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gfa
  extends erp
{
  public LinkedList<Integer> accx;
  public String appid;
  public int id;
  public String query;
  
  public gfa()
  {
    AppMethodBeat.i(121118);
    this.accx = new LinkedList();
    AppMethodBeat.o(121118);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(121119);
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
      paramVarArgs.bS(3, this.id);
      paramVarArgs.e(4, 2, this.accx);
      if (this.query != null) {
        paramVarArgs.g(5, this.query);
      }
      AppMethodBeat.o(121119);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label511;
      }
    }
    label511:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.appid != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.appid);
      }
      i = i + i.a.a.b.b.a.cJ(3, this.id) + i.a.a.a.c(4, 2, this.accx);
      paramInt = i;
      if (this.query != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.query);
      }
      AppMethodBeat.o(121119);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.accx.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(121119);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        gfa localgfa = (gfa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(121119);
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
            localgfa.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(121119);
          return 0;
        case 2: 
          localgfa.appid = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(121119);
          return 0;
        case 3: 
          localgfa.id = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(121119);
          return 0;
        case 4: 
          localgfa.accx.add(Integer.valueOf(((i.a.a.a.a)localObject).ajGk.aar()));
          AppMethodBeat.o(121119);
          return 0;
        }
        localgfa.query = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(121119);
        return 0;
      }
      AppMethodBeat.o(121119);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gfa
 * JD-Core Version:    0.7.0.1
 */