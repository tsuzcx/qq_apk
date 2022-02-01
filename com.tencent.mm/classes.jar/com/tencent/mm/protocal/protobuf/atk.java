package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class atk
  extends erp
{
  public int ACR;
  public String AUV;
  public atz CJv;
  public String YIZ;
  public int ZDP;
  public aur ZDQ;
  public long ZDR;
  public String firstPageMD5;
  public b lastBuffer;
  public long maxId;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258325);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.username != null) {
        paramVarArgs.g(2, this.username);
      }
      paramVarArgs.bv(3, this.maxId);
      if (this.firstPageMD5 != null) {
        paramVarArgs.g(4, this.firstPageMD5);
      }
      if (this.YIZ != null) {
        paramVarArgs.g(5, this.YIZ);
      }
      paramVarArgs.bS(6, this.ZDP);
      if (this.CJv != null)
      {
        paramVarArgs.qD(7, this.CJv.computeSize());
        this.CJv.writeFields(paramVarArgs);
      }
      if (this.lastBuffer != null) {
        paramVarArgs.d(8, this.lastBuffer);
      }
      paramVarArgs.bS(9, this.ACR);
      if (this.ZDQ != null)
      {
        paramVarArgs.qD(10, this.ZDQ.computeSize());
        this.ZDQ.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(11, this.ZDR);
      if (this.AUV != null) {
        paramVarArgs.g(12, this.AUV);
      }
      AppMethodBeat.o(258325);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1040;
      }
    }
    label1040:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.username != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.username);
      }
      i += i.a.a.b.b.a.q(3, this.maxId);
      paramInt = i;
      if (this.firstPageMD5 != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.firstPageMD5);
      }
      i = paramInt;
      if (this.YIZ != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.YIZ);
      }
      i += i.a.a.b.b.a.cJ(6, this.ZDP);
      paramInt = i;
      if (this.CJv != null) {
        paramInt = i + i.a.a.a.qC(7, this.CJv.computeSize());
      }
      i = paramInt;
      if (this.lastBuffer != null) {
        i = paramInt + i.a.a.b.b.a.c(8, this.lastBuffer);
      }
      i += i.a.a.b.b.a.cJ(9, this.ACR);
      paramInt = i;
      if (this.ZDQ != null) {
        paramInt = i + i.a.a.a.qC(10, this.ZDQ.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.q(11, this.ZDR);
      paramInt = i;
      if (this.AUV != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.AUV);
      }
      AppMethodBeat.o(258325);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258325);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        atk localatk = (atk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258325);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localatk.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258325);
          return 0;
        case 2: 
          localatk.username = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258325);
          return 0;
        case 3: 
          localatk.maxId = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(258325);
          return 0;
        case 4: 
          localatk.firstPageMD5 = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258325);
          return 0;
        case 5: 
          localatk.YIZ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258325);
          return 0;
        case 6: 
          localatk.ZDP = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258325);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new atz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((atz)localObject2).parseFrom((byte[])localObject1);
            }
            localatk.CJv = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258325);
          return 0;
        case 8: 
          localatk.lastBuffer = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(258325);
          return 0;
        case 9: 
          localatk.ACR = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258325);
          return 0;
        case 10: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aur();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aur)localObject2).parseFrom((byte[])localObject1);
            }
            localatk.ZDQ = ((aur)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258325);
          return 0;
        case 11: 
          localatk.ZDR = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(258325);
          return 0;
        }
        localatk.AUV = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(258325);
        return 0;
      }
      AppMethodBeat.o(258325);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.atk
 * JD-Core Version:    0.7.0.1
 */