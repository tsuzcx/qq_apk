package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dye
  extends cvw
{
  public int Gdy;
  public int GeT;
  public cxn HGC;
  public String HZg;
  public int HZi;
  public int Idd;
  public LinkedList<cxn> Ide;
  public int Idf;
  public int Scene;
  public int ijY;
  public SKBuiltinBuffer_t xsE;
  
  public dye()
  {
    AppMethodBeat.i(148668);
    this.Ide = new LinkedList();
    AppMethodBeat.o(148668);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(148669);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.xsE == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(148669);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.xsE != null)
      {
        paramVarArgs.lJ(2, this.xsE.computeSize());
        this.xsE.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.GeT);
      if (this.HZg != null) {
        paramVarArgs.d(4, this.HZg);
      }
      paramVarArgs.aS(5, this.ijY);
      paramVarArgs.aS(6, this.HZi);
      paramVarArgs.aS(7, this.Gdy);
      paramVarArgs.aS(8, this.Idd);
      paramVarArgs.e(9, 8, this.Ide);
      if (this.HGC != null)
      {
        paramVarArgs.lJ(10, this.HGC.computeSize());
        this.HGC.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(11, this.Idf);
      paramVarArgs.aS(12, this.Scene);
      AppMethodBeat.o(148669);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1182;
      }
    }
    label1182:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xsE != null) {
        i = paramInt + f.a.a.a.lI(2, this.xsE.computeSize());
      }
      i += f.a.a.b.b.a.bz(3, this.GeT);
      paramInt = i;
      if (this.HZg != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HZg);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.ijY) + f.a.a.b.b.a.bz(6, this.HZi) + f.a.a.b.b.a.bz(7, this.Gdy) + f.a.a.b.b.a.bz(8, this.Idd) + f.a.a.a.c(9, 8, this.Ide);
      paramInt = i;
      if (this.HGC != null) {
        paramInt = i + f.a.a.a.lI(10, this.HGC.computeSize());
      }
      i = f.a.a.b.b.a.bz(11, this.Idf);
      int j = f.a.a.b.b.a.bz(12, this.Scene);
      AppMethodBeat.o(148669);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Ide.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.xsE == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(148669);
          throw paramVarArgs;
        }
        AppMethodBeat.o(148669);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dye localdye = (dye)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(148669);
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
            localdye.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148669);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdye.xsE = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148669);
          return 0;
        case 3: 
          localdye.GeT = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(148669);
          return 0;
        case 4: 
          localdye.HZg = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(148669);
          return 0;
        case 5: 
          localdye.ijY = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(148669);
          return 0;
        case 6: 
          localdye.HZi = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(148669);
          return 0;
        case 7: 
          localdye.Gdy = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(148669);
          return 0;
        case 8: 
          localdye.Idd = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(148669);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdye.Ide.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148669);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdye.HGC = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148669);
          return 0;
        case 11: 
          localdye.Idf = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(148669);
          return 0;
        }
        localdye.Scene = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(148669);
        return 0;
      }
      AppMethodBeat.o(148669);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dye
 * JD-Core Version:    0.7.0.1
 */