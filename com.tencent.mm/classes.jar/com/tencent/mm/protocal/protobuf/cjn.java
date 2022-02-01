package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cjn
  extends esc
{
  public int YFu;
  public String aase;
  public int aasf;
  public int aasg;
  public LinkedList<Integer> aash;
  public LinkedList<aov> aasi;
  public int aasj;
  
  public cjn()
  {
    AppMethodBeat.i(258457);
    this.aash = new LinkedList();
    this.aasi = new LinkedList();
    AppMethodBeat.o(258457);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258461);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(258461);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.aasf);
      paramVarArgs.bS(3, this.aasg);
      paramVarArgs.bS(4, this.YFu);
      paramVarArgs.e(5, 2, this.aash);
      paramVarArgs.e(6, 8, this.aasi);
      paramVarArgs.bS(7, this.aasj);
      if (this.aase != null) {
        paramVarArgs.g(8, this.aase);
      }
      AppMethodBeat.o(258461);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label745;
      }
    }
    label745:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.aasf) + i.a.a.b.b.a.cJ(3, this.aasg) + i.a.a.b.b.a.cJ(4, this.YFu) + i.a.a.a.c(5, 2, this.aash) + i.a.a.a.c(6, 8, this.aasi) + i.a.a.b.b.a.cJ(7, this.aasj);
      paramInt = i;
      if (this.aase != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.aase);
      }
      AppMethodBeat.o(258461);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aash.clear();
        this.aasi.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(258461);
          throw paramVarArgs;
        }
        AppMethodBeat.o(258461);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cjn localcjn = (cjn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258461);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localcjn.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258461);
          return 0;
        case 2: 
          localcjn.aasf = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258461);
          return 0;
        case 3: 
          localcjn.aasg = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258461);
          return 0;
        case 4: 
          localcjn.YFu = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258461);
          return 0;
        case 5: 
          localcjn.aash.add(Integer.valueOf(((i.a.a.a.a)localObject1).ajGk.aar()));
          AppMethodBeat.o(258461);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aov();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aov)localObject2).parseFrom((byte[])localObject1);
            }
            localcjn.aasi.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258461);
          return 0;
        case 7: 
          localcjn.aasj = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258461);
          return 0;
        }
        localcjn.aase = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(258461);
        return 0;
      }
      AppMethodBeat.o(258461);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjn
 * JD-Core Version:    0.7.0.1
 */