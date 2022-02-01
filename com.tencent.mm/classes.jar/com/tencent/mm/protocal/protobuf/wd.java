package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class wd
  extends cqk
{
  public String Ecm;
  public int EqA;
  public int Eqy;
  public LinkedList<dht> Eqz;
  public String Md5;
  public int Version;
  
  public wd()
  {
    AppMethodBeat.i(6405);
    this.Eqz = new LinkedList();
    AppMethodBeat.o(6405);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6406);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(6406);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.Version);
      if (this.Ecm != null) {
        paramVarArgs.d(3, this.Ecm);
      }
      if (this.Md5 != null) {
        paramVarArgs.d(4, this.Md5);
      }
      paramVarArgs.aR(5, this.Eqy);
      paramVarArgs.e(6, 8, this.Eqz);
      paramVarArgs.aR(7, this.EqA);
      AppMethodBeat.o(6406);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label775;
      }
    }
    label775:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.Version);
      paramInt = i;
      if (this.Ecm != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Ecm);
      }
      i = paramInt;
      if (this.Md5 != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Md5);
      }
      paramInt = f.a.a.b.b.a.bx(5, this.Eqy);
      int j = f.a.a.a.c(6, 8, this.Eqz);
      int k = f.a.a.b.b.a.bx(7, this.EqA);
      AppMethodBeat.o(6406);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Eqz.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(6406);
          throw paramVarArgs;
        }
        AppMethodBeat.o(6406);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        wd localwd = (wd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(6406);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localwd.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(6406);
          return 0;
        case 2: 
          localwd.Version = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(6406);
          return 0;
        case 3: 
          localwd.Ecm = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(6406);
          return 0;
        case 4: 
          localwd.Md5 = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(6406);
          return 0;
        case 5: 
          localwd.Eqy = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(6406);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dht();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dht)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localwd.Eqz.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(6406);
          return 0;
        }
        localwd.EqA = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(6406);
        return 0;
      }
      AppMethodBeat.o(6406);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wd
 * JD-Core Version:    0.7.0.1
 */