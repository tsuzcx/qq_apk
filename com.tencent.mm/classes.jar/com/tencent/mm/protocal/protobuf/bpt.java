package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bpt
  extends cvp
{
  public String FHb;
  public cpz FHh;
  public String GaZ;
  public String Gba;
  public int Gbb;
  public att Gbc;
  public ng Gbd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124518);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(124518);
        throw paramVarArgs;
      }
      if (this.FHh == null)
      {
        paramVarArgs = new b("Not all required fields were included: qy_base_resp");
        AppMethodBeat.o(124518);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.FHh != null)
      {
        paramVarArgs.lC(2, this.FHh.computeSize());
        this.FHh.writeFields(paramVarArgs);
      }
      if (this.FHb != null) {
        paramVarArgs.d(3, this.FHb);
      }
      paramVarArgs.aS(4, this.Gbb);
      if (this.Gbc != null)
      {
        paramVarArgs.lC(5, this.Gbc.computeSize());
        this.Gbc.writeFields(paramVarArgs);
      }
      if (this.Gbd != null)
      {
        paramVarArgs.lC(6, this.Gbd.computeSize());
        this.Gbd.writeFields(paramVarArgs);
      }
      if (this.GaZ != null) {
        paramVarArgs.d(7, this.GaZ);
      }
      if (this.Gba != null) {
        paramVarArgs.d(8, this.Gba);
      }
      AppMethodBeat.o(124518);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1098;
      }
    }
    label1098:
    for (int i = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FHh != null) {
        paramInt = i + f.a.a.a.lB(2, this.FHh.computeSize());
      }
      i = paramInt;
      if (this.FHb != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FHb);
      }
      i += f.a.a.b.b.a.bz(4, this.Gbb);
      paramInt = i;
      if (this.Gbc != null) {
        paramInt = i + f.a.a.a.lB(5, this.Gbc.computeSize());
      }
      i = paramInt;
      if (this.Gbd != null) {
        i = paramInt + f.a.a.a.lB(6, this.Gbd.computeSize());
      }
      paramInt = i;
      if (this.GaZ != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.GaZ);
      }
      i = paramInt;
      if (this.Gba != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.Gba);
      }
      AppMethodBeat.o(124518);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(124518);
          throw paramVarArgs;
        }
        if (this.FHh == null)
        {
          paramVarArgs = new b("Not all required fields were included: qy_base_resp");
          AppMethodBeat.o(124518);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124518);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bpt localbpt = (bpt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124518);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbpt.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124518);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cpz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cpz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbpt.FHh = ((cpz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124518);
          return 0;
        case 3: 
          localbpt.FHb = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(124518);
          return 0;
        case 4: 
          localbpt.Gbb = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(124518);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new att();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((att)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbpt.Gbc = ((att)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124518);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ng();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ng)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbpt.Gbd = ((ng)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124518);
          return 0;
        case 7: 
          localbpt.GaZ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(124518);
          return 0;
        }
        localbpt.Gba = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(124518);
        return 0;
      }
      AppMethodBeat.o(124518);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpt
 * JD-Core Version:    0.7.0.1
 */