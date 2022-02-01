package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class xm
  extends erp
{
  public int OhP;
  public String Okh;
  public String Oki;
  public String Oln;
  public String YGt;
  public String Zge;
  public String Zgf;
  public int amount;
  public int channel;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91403);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.YGt != null) {
        paramVarArgs.g(2, this.YGt);
      }
      if (this.Oln != null) {
        paramVarArgs.g(3, this.Oln);
      }
      paramVarArgs.bS(4, this.amount);
      if (this.Oki != null) {
        paramVarArgs.g(5, this.Oki);
      }
      if (this.Okh != null) {
        paramVarArgs.g(6, this.Okh);
      }
      paramVarArgs.bS(7, this.channel);
      paramVarArgs.bS(8, this.OhP);
      if (this.Zge != null) {
        paramVarArgs.g(9, this.Zge);
      }
      if (this.Zgf != null) {
        paramVarArgs.g(10, this.Zgf);
      }
      AppMethodBeat.o(91403);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label784;
      }
    }
    label784:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YGt != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.YGt);
      }
      i = paramInt;
      if (this.Oln != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.Oln);
      }
      i += i.a.a.b.b.a.cJ(4, this.amount);
      paramInt = i;
      if (this.Oki != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.Oki);
      }
      i = paramInt;
      if (this.Okh != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.Okh);
      }
      i = i + i.a.a.b.b.a.cJ(7, this.channel) + i.a.a.b.b.a.cJ(8, this.OhP);
      paramInt = i;
      if (this.Zge != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.Zge);
      }
      i = paramInt;
      if (this.Zgf != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.Zgf);
      }
      AppMethodBeat.o(91403);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91403);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        xm localxm = (xm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91403);
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
            localxm.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(91403);
          return 0;
        case 2: 
          localxm.YGt = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91403);
          return 0;
        case 3: 
          localxm.Oln = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91403);
          return 0;
        case 4: 
          localxm.amount = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91403);
          return 0;
        case 5: 
          localxm.Oki = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91403);
          return 0;
        case 6: 
          localxm.Okh = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91403);
          return 0;
        case 7: 
          localxm.channel = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91403);
          return 0;
        case 8: 
          localxm.OhP = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91403);
          return 0;
        case 9: 
          localxm.Zge = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91403);
          return 0;
        }
        localxm.Zgf = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(91403);
        return 0;
      }
      AppMethodBeat.o(91403);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xm
 * JD-Core Version:    0.7.0.1
 */