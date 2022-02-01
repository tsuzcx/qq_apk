package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ded
  extends dyy
{
  public String Olp;
  public String Olq;
  public String Olr;
  public int Ols;
  public String Olt;
  public String OmF;
  public ctc TLK;
  public String TLL;
  public ani TLM;
  public String TLN;
  public ctd fZQ;
  public int tqa;
  public String tqb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91559);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91559);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.tqa);
      if (this.tqb != null) {
        paramVarArgs.f(3, this.tqb);
      }
      if (this.TLK != null)
      {
        paramVarArgs.oE(4, this.TLK.computeSize());
        this.TLK.writeFields(paramVarArgs);
      }
      if (this.Olp != null) {
        paramVarArgs.f(5, this.Olp);
      }
      if (this.Olq != null) {
        paramVarArgs.f(6, this.Olq);
      }
      if (this.Olr != null) {
        paramVarArgs.f(7, this.Olr);
      }
      paramVarArgs.aY(8, this.Ols);
      if (this.Olt != null) {
        paramVarArgs.f(9, this.Olt);
      }
      if (this.TLL != null) {
        paramVarArgs.f(10, this.TLL);
      }
      if (this.TLM != null)
      {
        paramVarArgs.oE(11, this.TLM.computeSize());
        this.TLM.writeFields(paramVarArgs);
      }
      if (this.TLN != null) {
        paramVarArgs.f(12, this.TLN);
      }
      if (this.fZQ != null)
      {
        paramVarArgs.oE(99, this.fZQ.computeSize());
        this.fZQ.writeFields(paramVarArgs);
      }
      if (this.OmF != null) {
        paramVarArgs.f(100, this.OmF);
      }
      AppMethodBeat.o(91559);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1370;
      }
    }
    label1370:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.tqa);
      paramInt = i;
      if (this.tqb != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.tqb);
      }
      i = paramInt;
      if (this.TLK != null) {
        i = paramInt + g.a.a.a.oD(4, this.TLK.computeSize());
      }
      paramInt = i;
      if (this.Olp != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.Olp);
      }
      i = paramInt;
      if (this.Olq != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.Olq);
      }
      paramInt = i;
      if (this.Olr != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.Olr);
      }
      i = paramInt + g.a.a.b.b.a.bM(8, this.Ols);
      paramInt = i;
      if (this.Olt != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.Olt);
      }
      i = paramInt;
      if (this.TLL != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.TLL);
      }
      paramInt = i;
      if (this.TLM != null) {
        paramInt = i + g.a.a.a.oD(11, this.TLM.computeSize());
      }
      i = paramInt;
      if (this.TLN != null) {
        i = paramInt + g.a.a.b.b.a.g(12, this.TLN);
      }
      paramInt = i;
      if (this.fZQ != null) {
        paramInt = i + g.a.a.a.oD(99, this.fZQ.computeSize());
      }
      i = paramInt;
      if (this.OmF != null) {
        i = paramInt + g.a.a.b.b.a.g(100, this.OmF);
      }
      AppMethodBeat.o(91559);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91559);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91559);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ded localded = (ded)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91559);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localded.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91559);
          return 0;
        case 2: 
          localded.tqa = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91559);
          return 0;
        case 3: 
          localded.tqb = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91559);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ctc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ctc)localObject2).parseFrom((byte[])localObject1);
            }
            localded.TLK = ((ctc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91559);
          return 0;
        case 5: 
          localded.Olp = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91559);
          return 0;
        case 6: 
          localded.Olq = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91559);
          return 0;
        case 7: 
          localded.Olr = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91559);
          return 0;
        case 8: 
          localded.Ols = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91559);
          return 0;
        case 9: 
          localded.Olt = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91559);
          return 0;
        case 10: 
          localded.TLL = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91559);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ani();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ani)localObject2).parseFrom((byte[])localObject1);
            }
            localded.TLM = ((ani)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91559);
          return 0;
        case 12: 
          localded.TLN = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91559);
          return 0;
        case 99: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ctd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ctd)localObject2).parseFrom((byte[])localObject1);
            }
            localded.fZQ = ((ctd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91559);
          return 0;
        }
        localded.OmF = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(91559);
        return 0;
      }
      AppMethodBeat.o(91559);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ded
 * JD-Core Version:    0.7.0.1
 */