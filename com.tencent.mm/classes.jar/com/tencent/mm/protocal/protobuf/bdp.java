package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bdp
  extends cvw
{
  public int FSQ;
  public String GLP;
  public SKBuiltinBuffer_t GTa;
  public int GTb;
  public int GTc;
  public LinkedList<cle> GTd;
  public int GTe;
  public bug Guj;
  public int Scene;
  
  public bdp()
  {
    AppMethodBeat.i(32249);
    this.GTd = new LinkedList();
    AppMethodBeat.o(32249);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32250);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Guj == null)
      {
        paramVarArgs = new b("Not all required fields were included: Loc");
        AppMethodBeat.o(32250);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.FSQ);
      paramVarArgs.aS(3, this.Scene);
      if (this.GTa != null)
      {
        paramVarArgs.lJ(4, this.GTa.computeSize());
        this.GTa.writeFields(paramVarArgs);
      }
      if (this.Guj != null)
      {
        paramVarArgs.lJ(5, this.Guj.computeSize());
        this.Guj.writeFields(paramVarArgs);
      }
      if (this.GLP != null) {
        paramVarArgs.d(6, this.GLP);
      }
      paramVarArgs.aS(7, this.GTb);
      paramVarArgs.aS(8, this.GTc);
      paramVarArgs.e(11, 8, this.GTd);
      paramVarArgs.aS(12, this.GTe);
      AppMethodBeat.o(32250);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1126;
      }
    }
    label1126:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.FSQ) + f.a.a.b.b.a.bz(3, this.Scene);
      paramInt = i;
      if (this.GTa != null) {
        paramInt = i + f.a.a.a.lI(4, this.GTa.computeSize());
      }
      i = paramInt;
      if (this.Guj != null) {
        i = paramInt + f.a.a.a.lI(5, this.Guj.computeSize());
      }
      paramInt = i;
      if (this.GLP != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GLP);
      }
      i = f.a.a.b.b.a.bz(7, this.GTb);
      int j = f.a.a.b.b.a.bz(8, this.GTc);
      int k = f.a.a.a.c(11, 8, this.GTd);
      int m = f.a.a.b.b.a.bz(12, this.GTe);
      AppMethodBeat.o(32250);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GTd.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.Guj == null)
        {
          paramVarArgs = new b("Not all required fields were included: Loc");
          AppMethodBeat.o(32250);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32250);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bdp localbdp = (bdp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 9: 
        case 10: 
        default: 
          AppMethodBeat.o(32250);
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
            localbdp.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32250);
          return 0;
        case 2: 
          localbdp.FSQ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32250);
          return 0;
        case 3: 
          localbdp.Scene = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32250);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbdp.GTa = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32250);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bug();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bug)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbdp.Guj = ((bug)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32250);
          return 0;
        case 6: 
          localbdp.GLP = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32250);
          return 0;
        case 7: 
          localbdp.GTb = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32250);
          return 0;
        case 8: 
          localbdp.GTc = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32250);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cle();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cle)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbdp.GTd.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32250);
          return 0;
        }
        localbdp.GTe = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(32250);
        return 0;
      }
      AppMethodBeat.o(32250);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bdp
 * JD-Core Version:    0.7.0.1
 */