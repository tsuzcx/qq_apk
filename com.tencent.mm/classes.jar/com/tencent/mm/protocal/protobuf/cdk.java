package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cdk
  extends com.tencent.mm.bx.a
{
  public int CGI;
  public String CGK;
  public String CGL;
  public String CGM;
  public String CGN;
  public String CGO;
  public String CGP;
  public int CIy;
  public cdl GXy;
  public String GXz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72526);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.CIy);
      if (this.GXy != null)
      {
        paramVarArgs.lC(2, this.GXy.computeSize());
        this.GXy.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.CGI);
      if (this.CGK != null) {
        paramVarArgs.d(4, this.CGK);
      }
      if (this.CGL != null) {
        paramVarArgs.d(5, this.CGL);
      }
      if (this.CGM != null) {
        paramVarArgs.d(6, this.CGM);
      }
      if (this.CGN != null) {
        paramVarArgs.d(7, this.CGN);
      }
      if (this.CGO != null) {
        paramVarArgs.d(8, this.CGO);
      }
      if (this.CGP != null) {
        paramVarArgs.d(9, this.CGP);
      }
      if (this.GXz != null) {
        paramVarArgs.d(10, this.GXz);
      }
      AppMethodBeat.o(72526);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.CIy) + 0;
      paramInt = i;
      if (this.GXy != null) {
        paramInt = i + f.a.a.a.lB(2, this.GXy.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(3, this.CGI);
      paramInt = i;
      if (this.CGK != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.CGK);
      }
      i = paramInt;
      if (this.CGL != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.CGL);
      }
      paramInt = i;
      if (this.CGM != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.CGM);
      }
      i = paramInt;
      if (this.CGN != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.CGN);
      }
      paramInt = i;
      if (this.CGO != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.CGO);
      }
      i = paramInt;
      if (this.CGP != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.CGP);
      }
      paramInt = i;
      if (this.GXz != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.GXz);
      }
      AppMethodBeat.o(72526);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(72526);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cdk localcdk = (cdk)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(72526);
        return -1;
      case 1: 
        localcdk.CIy = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(72526);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cdl();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cdl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcdk.GXy = ((cdl)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72526);
        return 0;
      case 3: 
        localcdk.CGI = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(72526);
        return 0;
      case 4: 
        localcdk.CGK = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(72526);
        return 0;
      case 5: 
        localcdk.CGL = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(72526);
        return 0;
      case 6: 
        localcdk.CGM = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(72526);
        return 0;
      case 7: 
        localcdk.CGN = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(72526);
        return 0;
      case 8: 
        localcdk.CGO = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(72526);
        return 0;
      case 9: 
        localcdk.CGP = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(72526);
        return 0;
      }
      localcdk.GXz = ((f.a.a.a.a)localObject1).NPN.readString();
      AppMethodBeat.o(72526);
      return 0;
    }
    AppMethodBeat.o(72526);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdk
 * JD-Core Version:    0.7.0.1
 */