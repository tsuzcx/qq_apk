package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bcw
  extends cvw
{
  public int GSs;
  public LinkedList<abf> GSt;
  public String rie;
  public String rif;
  public int scene;
  public String version;
  
  public bcw()
  {
    AppMethodBeat.i(196265);
    this.GSt = new LinkedList();
    AppMethodBeat.o(196265);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(196266);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.rie == null)
      {
        paramVarArgs = new b("Not all required fields were included: rversion");
        AppMethodBeat.o(196266);
        throw paramVarArgs;
      }
      if (this.rif == null)
      {
        paramVarArgs = new b("Not all required fields were included: buildTag");
        AppMethodBeat.o(196266);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.GSs);
      paramVarArgs.aS(3, this.scene);
      if (this.version != null) {
        paramVarArgs.d(4, this.version);
      }
      if (this.rie != null) {
        paramVarArgs.d(5, this.rie);
      }
      if (this.rif != null) {
        paramVarArgs.d(6, this.rif);
      }
      paramVarArgs.e(7, 8, this.GSt);
      AppMethodBeat.o(196266);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label818;
      }
    }
    label818:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.GSs) + f.a.a.b.b.a.bz(3, this.scene);
      paramInt = i;
      if (this.version != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.version);
      }
      i = paramInt;
      if (this.rie != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.rie);
      }
      paramInt = i;
      if (this.rif != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.rif);
      }
      i = f.a.a.a.c(7, 8, this.GSt);
      AppMethodBeat.o(196266);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GSt.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.rie == null)
        {
          paramVarArgs = new b("Not all required fields were included: rversion");
          AppMethodBeat.o(196266);
          throw paramVarArgs;
        }
        if (this.rif == null)
        {
          paramVarArgs = new b("Not all required fields were included: buildTag");
          AppMethodBeat.o(196266);
          throw paramVarArgs;
        }
        AppMethodBeat.o(196266);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bcw localbcw = (bcw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(196266);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbcw.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(196266);
          return 0;
        case 2: 
          localbcw.GSs = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(196266);
          return 0;
        case 3: 
          localbcw.scene = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(196266);
          return 0;
        case 4: 
          localbcw.version = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(196266);
          return 0;
        case 5: 
          localbcw.rie = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(196266);
          return 0;
        case 6: 
          localbcw.rif = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(196266);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new abf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((abf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbcw.GSt.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(196266);
        return 0;
      }
      AppMethodBeat.o(196266);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcw
 * JD-Core Version:    0.7.0.1
 */